package com.database.MPT.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/user").setViewName("user");
        //registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/showAdresy").setViewName("showAdresy");
        registry.addViewController("/showPoczty").setViewName("showPoczty");
        registry.addViewController("/userAdresy").setViewName("userAdresy");
        registry.addViewController("/userPoczty").setViewName("userPoczty");
        registry.addViewController("/showPracownicy").setViewName("showPracownicy");
    }

    @Controller
    public class DashboardController {
        @RequestMapping("/redirect")
        public String defaultAfterLogin(HttpServletRequest request) {
            if(request.isUserInRole("ADMIN")) {
                return "redirect:/hello";
            }
            else if(request.isUserInRole("USER")) {
                return "redirect:/user";
            }
            else {
                return "redirect:/index";
            }
        }
    }
}
