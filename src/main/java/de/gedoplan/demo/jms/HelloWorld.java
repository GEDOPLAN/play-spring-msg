package de.gedoplan.demo.jms;

import de.gedoplan.demo.HelloMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RestController("jms")
@RequestMapping("demo/jms")
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

    @PostMapping(path = "q")
    public ResponseEntity postHelloToOne(@RequestBody String msg){
        jmsQueue.convertAndSend("demo", new HelloMessage(msg));
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "t")
    public ResponseEntity postHelloToAll(@RequestBody String msg){
        jmsTopic.convertAndSend("demo", new HelloMessage(msg));
        return ResponseEntity.ok().build();
    }

}
