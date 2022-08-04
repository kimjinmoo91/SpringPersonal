package com.sparta.springcore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProductRequestDto {
    // 관심상품명
    private String title;
    // 관심상품 썸네일 image URL
    private String image;
    // 관심상품 구매링크 URL
    private String link;
    // 관심상품의 최저가
    private int lprice;

    @Controller
    public static class LoginController {

        // Login 을 위한 HTML 파일 내려주기
        @GetMapping("/login")
        public String loginPage() {
            return "redirect:/login-form.html";
        }

        // Login 처리
        @PostMapping("/login")
        public String loginProcess(
                @RequestParam String id,
                @RequestParam String password,
                Model model
        ) {
            if (id.equals(password)) {
                model.addAttribute("loginId", id);
            }

            return "login-result";
        }
    }
}

