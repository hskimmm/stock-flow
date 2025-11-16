package com.spring.stockflow.controller.notice;

import com.spring.stockflow.domain.Notice;
import com.spring.stockflow.service.notice.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
