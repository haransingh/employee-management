package com.fiveExceptions.service;

import com.fiveExceptions.config.MessageQueueConfig;
import com.fiveExceptions.dto.EmployeeResponse;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

//    @RabbitListener(queues = MessageQueueConfig.QUEUE)
//    public void consumeMessageFromQueue(EmployeeResponse employeeResponse) {
//        System.out.println("Message received from queue : " + employeeResponse);
//    }

}
