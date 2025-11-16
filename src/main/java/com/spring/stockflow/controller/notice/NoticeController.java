package com.spring.stockflow.controller.notice;

import com.spring.stockflow.domain.Notice;
import com.spring.stockflow.dto.UserDTO;
import com.spring.stockflow.dto.notice.CreateNoticeDTO;
import com.spring.stockflow.dto.notice.EditNoticeDTO;
import com.spring.stockflow.response.ApiResponse;
import com.spring.stockflow.service.notice.NoticeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/notice")
@RequiredArgsConstructor
@Log4j2
public class NoticeController {

    private final NoticeService noticeService;

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
}
