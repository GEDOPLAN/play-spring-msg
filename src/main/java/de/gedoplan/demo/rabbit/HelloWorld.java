package de.gedoplan.demo.rabbit;

import de.gedoplan.demo.HelloMessage;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RestController("rabbit")
@RequestMapping("demo/rabbit")
public class HelloWorld {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private FanoutExchange fanout;

    @GetMapping
    public HelloMessage getHello(){
        return new HelloMessage("Hello World");
    }

    @PostMapping(path = "q")
    public ResponseEntity postHelloToOne(@RequestBody String msg){
        rabbitTemplate.convertAndSend("exchangeDirect", "demo", new HelloMessage(msg));
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "t")
    public ResponseEntity postHelloToAll(@RequestBody String msg){
        rabbitTemplate.convertAndSend(fanout.getName(), "", new HelloMessage(msg));
        return ResponseEntity.ok().build();
    }

}
