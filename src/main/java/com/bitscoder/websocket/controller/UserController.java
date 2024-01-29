package com.bitscoder.websocket.controller;

import com.bitscoder.websocket.model.User;
import com.bitscoder.websocket.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @MessageMapping("/app/user.addUser")
    @SendTo("user/public")
    public User saveUser(@Payload User user) {
        userService.saveUser(user);
        return user;
    }

    @MessageMapping("/app/user.disconnectUser")
    @SendTo("user/public")
    public User disconnectUser(@Payload User user) {
        userService.disconnectUser(user);
        return user;
    }

    @GetMapping("/app/users")
    public ResponseEntity<List<User>> getConnectedUsers() {
        return ResponseEntity.ok(userService.findConnectedUsers());
    }
}
