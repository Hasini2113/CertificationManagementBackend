package com.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotificationResponseDto {

    private Long id;
    private String message;
    private boolean isRead;
    private String createdAt;
}
