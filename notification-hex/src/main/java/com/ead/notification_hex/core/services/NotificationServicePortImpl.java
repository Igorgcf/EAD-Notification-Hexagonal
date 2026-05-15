package com.ead.notification_hex.core.services;

import com.ead.notification_hex.adapters.dtos.NotificationDTO;
import com.ead.notification_hex.core.domain.NotificationDomain;
import com.ead.notification_hex.core.domain.PageInfo;
import com.ead.notification_hex.core.domain.enums.NotificationStatus;
import com.ead.notification_hex.core.ports.NotificationPersistencePort;
import com.ead.notification_hex.core.ports.NotificationServicePort;
import com.ead.notification_hex.core.services.exceptions.ResourceNotFoundException;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class NotificationServicePortImpl implements NotificationServicePort {

    private final NotificationPersistencePort notificationPersistencePort;

    public NotificationServicePortImpl(NotificationPersistencePort notificationPersistencePort) {
        this.notificationPersistencePort = notificationPersistencePort;
    }

    public void save(NotificationDTO dto) {

        NotificationDomain notification = new NotificationDomain();
        copyDtoToEntity(notification, dto);
        notificationPersistencePort.save(notification);
    }

    public List<NotificationDTO> findAllUsersNotification(UUID userId, PageInfo pageInfo) {

        List<NotificationDomain> list = notificationPersistencePort.findAllByUserIdAndNotificationStatus(userId, NotificationStatus.CREATED, pageInfo);
        return list.stream().map(x -> new NotificationDTO(x)).collect(Collectors.toList());
    }

    public NotificationDTO updateNotificationStatus(UUID id, UUID userId, NotificationDTO dto) {

        Optional<NotificationDomain> obj = notificationPersistencePort.findByNotificationIdAndUserId(id, userId);
        NotificationDomain entity = obj.orElseThrow(() -> new ResourceNotFoundException("Notification not found. | NotificationId" + id + " | UserId: " + userId));
        if(dto.getNotificationStatus() != null){
            entity.setNotificationStatus(dto.getNotificationStatus());
        }
        notificationPersistencePort.save(entity);

        return new NotificationDTO(entity);
    }


    public void copyDtoToEntity(NotificationDomain entity, NotificationDTO dto){

        entity.setUserId(dto.getUserId());
        entity.setTitle(dto.getTitle());
        entity.setMessage(dto.getMessage());
        entity.setCreationDate(LocalDateTime.now(ZoneId.of("UTC")));
        entity.setNotificationStatus(NotificationStatus.CREATED);
    }
}
