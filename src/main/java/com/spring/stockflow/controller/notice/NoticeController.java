package com.spring.stockflow.controller.notice;

import com.spring.stockflow.domain.File;
import com.spring.stockflow.domain.Notice;
import com.spring.stockflow.dto.UserDTO;
import com.spring.stockflow.dto.notice.CreateNoticeDTO;
import com.spring.stockflow.dto.notice.EditNoticeDTO;
import com.spring.stockflow.mapper.file.FileMapper;
import com.spring.stockflow.response.ApiResponse;
import com.spring.stockflow.service.notice.NoticeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URLEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/notice")
@RequiredArgsConstructor
@Log4j2
public class NoticeController {

    private final NoticeService noticeService;
    private final FileMapper fileMapper;

    @Value("${file.upload.path}")
    private String uploadPath;

    @GetMapping
    public String getNotices(Model model) {
        List<Notice> noticeList = noticeService.getNotices();
        model.addAttribute("noticeList", noticeList);
        model.addAttribute("menuActive", "notice");
        return "notice/notice-list";
    }

    @GetMapping("/{id}")
    public String getNotice(@PathVariable(value = "id") Long id, Model model) {
        Notice notice = noticeService.getNotice(id);
        model.addAttribute("notice", notice);
        model.addAttribute("menuActive", "notice");
        return "notice/notice-detail";
    }

    @GetMapping("/add")
    public String addNoticeForm(@AuthenticationPrincipal UserDTO userDTO, Model model) {
        model.addAttribute("userId", userDTO.getId());
        model.addAttribute("menuActive", "notice");
        return "notice/notice-add";
    }

    @PostMapping
    public ResponseEntity<ApiResponse<?>> addNotice(@Valid @ModelAttribute CreateNoticeDTO createNoticeDTO, @RequestParam(value = "files", required = false) List<MultipartFile> files) {
        ApiResponse<?> response = noticeService.addNotice(createNoticeDTO, files);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/edit/{id}")
    public String editNoticeForm(@PathVariable(value = "id") Long id, Model model) {
        Notice notice = noticeService.getNoticeDetail(id);
        model.addAttribute("notice", notice);
        model.addAttribute("menuActive", "notice");
        return "notice/notice-edit";
    }

    @PutMapping
    public ResponseEntity<ApiResponse<?>> editNotice(@Valid @ModelAttribute EditNoticeDTO editNoticeDTO,
                                                     @RequestParam(value = "files", required = false) List<MultipartFile> files,
                                                     @RequestParam(value = "deletedFileIds", required = false) String[] deletedFileIds) {

        ApiResponse<?> response = noticeService.editNotice(editNoticeDTO, files, deletedFileIds);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deleteNotice(@PathVariable(value = "id") Long id) {
        ApiResponse<?> response = noticeService.deleteNotice(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable(value = "id") Long id) {
        try {
            File file = fileMapper.getFileById(id);

            if (file == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            //파일경로 설정
            String fullPath = uploadPath + java.io.File.separator
                            + file.getFilePath() + java.io.File.separator
                            + file.getSavedName();

            Path path = Paths.get(fullPath);
            Resource resource = new UrlResource(path.toUri());

            if (!resource.exists()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            //파일명 인코딩
            String encodedFileName = URLEncoder.encode(file.getOriginalName(), "UTF-8").replaceAll("\\+", "%20");

            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .header(HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename=\"" + encodedFileName + "\"")
                    .body(resource);

        } catch (Exception e) {
            log.error("파일 다운로드(기타 오류) = {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
