package com.ead.notification_hex.adapters.dtos;

import com.ead.notification_hex.core.domain.NotificationDomain;
import com.ead.notification_hex.core.domain.enums.NotificationStatus;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class NotificationDTO {

    private UUID id;
    private UUID userId;
    private String title;
    private String message;
    private LocalDateTime creationDate;
    private NotificationStatus notificationStatus;

    public NotificationDTO() {
    }

    public NotificationDTO(NotificationDomain entity){
        this.id = entity.getId();
        this.userId = entity.getUserId();
        this.title = entity.getTitle();
        this.message = entity.getMessage();
        this.creationDate = entity.getCreationDate();
        this.notificationStatus = entity.getNotificationStatus();
    }

}
