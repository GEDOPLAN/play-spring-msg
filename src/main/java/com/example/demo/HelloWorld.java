package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("demo")
public class HelloWorld {

    @Autowired()
    @Qualifier("topicTemplate")
    private JmsTemplate jmsTopic;

    @Autowired()
    @Qualifier("queueTemplate")
    private JmsTemplate jmsQueue;

    @GetMapping
    public HelloMessage getHello(){
        return new HelloMessage("Hello World");
    }

    @PostMapping(path = "t")
    public ResponseEntity postHelloToOne(@RequestBody String msg){
        jmsTopic.convertAndSend("demo", new HelloMessage(msg));
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "q")
    public ResponseEntity postHelloToAll(@RequestBody String msg){
        jmsQueue.convertAndSend("demo", new HelloMessage(msg));
        return ResponseEntity.ok().build();
    }

}
