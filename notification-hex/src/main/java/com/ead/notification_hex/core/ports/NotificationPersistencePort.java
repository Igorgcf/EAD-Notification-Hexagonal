package com.ead.notification_hex.core.ports;

import com.ead.notification_hex.core.domain.NotificationDomain;
import com.ead.notification_hex.core.domain.PageInfo;
import com.ead.notification_hex.core.domain.enums.NotificationStatus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NotificationPersistencePort {

    void save(NotificationDomain notificationDomain);

    List<NotificationDomain>findAllByUserIdAndNotificationStatus(UUID userId, NotificationStatus status, PageInfo pageInfo);

    Optional<NotificationDomain> findByNotificationIdAndUserId(UUID notificationId, UUID userId);

}
