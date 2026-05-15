package com.ead.notification_hex.adapters.inbound.consumers;

import com.ead.notification_hex.adapters.dtos.NotificationDTO;
import com.ead.notification_hex.core.ports.NotificationServicePort;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumer {

    @Autowired
    private NotificationServicePort service;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue (value = "${ead.broker.queue.notificationCommandQueue.name}", durable = "true"),
            exchange = @Exchange (value = "${ead.broker.exchange.notificationCommandExchange}", type = ExchangeTypes.TOPIC, ignoreDeclarationExceptions = "true"),
            key = "${ead.broker.key.notificationCommandKey}"))
    public void listen(@Payload NotificationDTO dto) {

       service.save(dto);

    }


}
