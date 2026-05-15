package com.ead.notification_hex.core.ports;

import com.ead.notification_hex.adapters.dtos.NotificationDTO;
import com.ead.notification_hex.core.domain.PageInfo;

import java.util.List;
import java.util.UUID;

public interface NotificationServicePort {

    void save(NotificationDTO dto);

    List<NotificationDTO> findAllUsersNotification(UUID userId, PageInfo pageable);

    NotificationDTO updateNotificationStatus(UUID notificationId, UUID userId, NotificationDTO dto);
}
