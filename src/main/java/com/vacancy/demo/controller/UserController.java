package com.vacancy.demo.controller;

import com.vacancy.demo.dto.UpdateInfo;
import com.vacancy.demo.service.UserService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("update")
    public void updateInfo(@RequestBody @Valid UpdateInfo updateInfo){
        userService.updateUser(updateInfo);
    }
}
