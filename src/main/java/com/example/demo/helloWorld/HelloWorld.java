package com.example.demo.helloWorld;

public class HelloWorld {
    private String message;

    public HelloWorld(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorld{" +
                "message='" + message + '\'' +
                '}';
    }
}
