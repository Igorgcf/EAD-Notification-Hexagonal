package com.ead.notification_hex.adapters.outbound.persistence;

import com.ead.notification_hex.adapters.outbound.persistence.entities.NotificationEntity;
import com.ead.notification_hex.core.domain.NotificationDomain;
import com.ead.notification_hex.core.domain.PageInfo;
import com.ead.notification_hex.core.domain.enums.NotificationStatus;
import com.ead.notification_hex.core.ports.NotificationPersistencePort;
import com.ead.notification_hex.core.services.exceptions.ResourceNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Log4j2
@Component
public class NotificationPersistencePortImpl implements NotificationPersistencePort {

    private final NotificationJpaRepository repository;

    ModelMapper mapper;

    public NotificationPersistencePortImpl(NotificationJpaRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    @Override
    public void save(NotificationDomain notificationDomain) {

        log.debug("save domain received: {}", notificationDomain);
        NotificationEntity entity = repository.save(mapper.map(notificationDomain, NotificationEntity.class));
        log.debug("save entity saved: {}", entity);
        log.info("Notification saved successfully");
    }

    @Transactional
    @Override
    public List<NotificationDomain> findAllByUserIdAndNotificationStatus(UUID userId, NotificationStatus notificationStatus, PageInfo pageInfo) {

        Pageable pageable = PageRequest.of(pageInfo.getPageNumber(), pageInfo.getPageSize());
        List<NotificationDomain> list = repository.findAllByUserIdAndNotificationStatus(userId, notificationStatus, pageable).stream().map(x -> mapper.map(x, NotificationDomain.class))
                .collect(Collectors.toList());

        return list;
    }

    @Transactional
    @Override
    public Optional<NotificationDomain> findByNotificationIdAndUserId(UUID notificationId, UUID userId) {

        Optional<NotificationEntity> obj = repository.findByIdAndUserId(notificationId, userId);

        if(obj.isEmpty()){
            throw new ResourceNotFoundException("Notification not found. | NotificationId" + notificationId + " | UserId: " + userId);
        }
        return Optional.of(mapper.map(obj.get(), NotificationDomain.class));
        }
    }
