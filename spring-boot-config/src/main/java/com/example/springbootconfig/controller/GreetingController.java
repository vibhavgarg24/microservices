package com.example.springbootconfig.controller;

import com.example.springbootconfig.config.DbConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GreetingController {

    @Value("${my.greeting: hello}")
    private String greetingMessage;
    @Value("${my.value.list}")
    private List<String> valueList;
    @Value("#{${db.value}}")
    private Map<String, String> dbValue;
    @Autowired
    private DbConfig dbConfig;

    @GetMapping("greeting")
    public String greeting() {
        return greetingMessage;
    }

    @GetMapping("valueList")
    public List<String> getValueList() {
        return valueList;
    }

    @GetMapping("dbValue")
    public Map<String, String> getDbValue() {
        return dbValue;
    }

    @GetMapping("dbConfig")
    public String getDbConfig() {
        return dbConfig.toString();
    }
}
