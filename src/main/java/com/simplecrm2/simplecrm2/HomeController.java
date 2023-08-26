package com.simplecrm2.simplecrm2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// @Controller // like @component but it returns view only.
// @ResponseBody
@RestController // @Controller + @ResponseBody
public class HomeController {
    @GetMapping("/home")
    public String home1() {
        return "home1";
    }

    @GetMapping("/")
    public String home2() {
        return "home2";
    }

}
