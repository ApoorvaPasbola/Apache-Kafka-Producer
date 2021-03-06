package com.apoorva.kafka.springbootkafkaproducerexample.resource;

import com.apoorva.kafka.springbootkafkaproducerexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Kafka")
public class UserResource {
    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;
    private static final String TOPIC = "Kafka_Example2";

    @GetMapping("publish/{name}")
    public String post(@PathVariable("name") final String name)
    {
        kafkaTemplate.send(TOPIC,new User(name,"CSE",120000L));
        return "Published successfully";
    }
}
