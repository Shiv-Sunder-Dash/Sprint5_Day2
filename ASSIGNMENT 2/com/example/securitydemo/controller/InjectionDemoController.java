package com.example.securitydemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/injection")
public class InjectionDemoController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/bad")
    public String badSql(@RequestParam String username) {
        String sql = "SELECT password FROM user WHERE username = '" + username + "'";
        return jdbcTemplate.queryForObject(sql, String.class);
    }

    @GetMapping("/good")
    public String goodSql(@RequestParam String username) {
        String sql = "SELECT password FROM user WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, String.class, username);
    }
}
