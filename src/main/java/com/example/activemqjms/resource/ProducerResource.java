package com.example.activemqjms.resource;

import jakarta.jms.Destination;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import javax.jms.Queue;

@RestController
@RequestMapping("/rest/publish")
public class ProducerResource {

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    ActiveMQQueue queue;

    @RequestMapping( value="/{message}", method = RequestMethod.GET)
    public String publish(@PathVariable
                          final String message) {

        jmsTemplate.convertAndSend(queue, message);

        return message;
    }
}
