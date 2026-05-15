package com.ead.notification_hex.adapters.configs;

import com.ead.notification_hex.NotificationHexApplication;
import com.ead.notification_hex.core.ports.NotificationPersistencePort;
import com.ead.notification_hex.core.services.NotificationServicePortImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = NotificationHexApplication.class)
public class BeanConfiguration {

    @Bean
    NotificationServicePortImpl notificationServicePortImpl(NotificationPersistencePort persistence) {
        return new NotificationServicePortImpl(persistence);
    }

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
