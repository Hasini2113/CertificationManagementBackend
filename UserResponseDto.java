package com.project.controleer;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.NotificationResponseDto;
import com.project.service.NotificationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping("/user/{userId}")
    public List<NotificationResponseDto> getUserNotifications(
            @PathVariable Long userId) {

        return notificationService.getUserNotifications(userId);
    }

    @PutMapping("/{id}/read")
    public String markAsRead(@PathVariable Long id) {

        notificationService.markAsRead(id);
        return "Marked as read";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {

        notificationService.deleteNotification(id);
        return "Deleted";
    }
}