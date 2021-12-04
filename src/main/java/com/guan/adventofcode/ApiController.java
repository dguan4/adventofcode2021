package com.guan.adventofcode;

import com.guan.adventofcode.days.day1.Day1Application;
import com.guan.adventofcode.models.Answer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
@Slf4j
public class ApiController {

    @Autowired
    Day1Application day1Application;

    @RequestMapping("/day1")
    @ResponseBody
    String day1(@RequestParam(name="input") String input) {
        return Answer.builder()
                .FirstAnswer(day1Application.GetAnswer(input))
                .SecondAnswer(day1Application.GetAnswer2(input))
                .build()
                .toString();
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiController.class, args);
    }
}
