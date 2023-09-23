package com.example.demo.helloWorld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + @ResponseBody
public class HelloWorldResource {

    @RequestMapping("hello-world")
    String HelloWorldView(){
        return "Hello World";
    }

    @RequestMapping("hello-world-bean")
    HelloWorld HelloWorldBean(){
        return new HelloWorld("Hello, everybody!");
    }

}
