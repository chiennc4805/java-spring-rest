package vn.hoidanit.jobhunter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    // @CrossOrigin
    public String getHelloWorld() {
        return "update Hello World (Hỏi Dân IT & Eric)";
    }
}
