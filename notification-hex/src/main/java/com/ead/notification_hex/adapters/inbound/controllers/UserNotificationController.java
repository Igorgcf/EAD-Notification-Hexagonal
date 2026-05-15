package com.ead.notification_hex.adapters.inbound.controllers;

import com.ead.notification_hex.adapters.dtos.NotificationDTO;
import com.ead.notification_hex.core.domain.PageInfo;
import com.ead.notification_hex.core.ports.NotificationServicePort;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserNotificationController {

    private final NotificationServicePort service;

    public UserNotificationController(NotificationServicePort service) {
        this.service = service;
    }

    @PreAuthorize("hasAnyRole('STUDENT')")
    @GetMapping(value = "/users/{userId}/notifications")
    public ResponseEntity<Page<NotificationDTO>> findAllUsersNotification(@PathVariable UUID userId, Pageable pageable, Authentication authentication) {

        PageInfo pageInfo = new PageInfo();
        BeanUtils.copyProperties(pageable, pageInfo);

        List<NotificationDTO> list = service.findAllUsersNotification(userId, pageInfo);
        return ResponseEntity.status(HttpStatus.OK).body(new PageImpl<>(list, pageable, list.size()));
    }

    @PreAuthorize("hasAnyRole('STUDENT')")
    @PutMapping(value = "/users/{userId}/notifications/{id}")
    public ResponseEntity<NotificationDTO> updateNotificationStatus(@PathVariable UUID userId,
                                                                    @PathVariable UUID id,
                                                                    @RequestBody NotificationDTO dto){

        dto = service.updateNotificationStatus(id, userId, dto);
        return ResponseEntity.ok().body(dto);
    }
}
