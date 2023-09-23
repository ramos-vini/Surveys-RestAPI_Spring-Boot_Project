package com.example.demo.helloWorld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldResource {

    @RequestMapping
    @ResponseBody
    String HelloWorldView(){
        return "Hello World";
    }

}
