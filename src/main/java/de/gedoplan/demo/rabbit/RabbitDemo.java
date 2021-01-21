package de.gedoplan.demo.rabbit;

import de.gedoplan.demo.HelloMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitDemo {


    @RabbitListener(queues = "rabbitQueueQ")
    public void receiver(HelloMessage message) {
        System.out.println(" Rabbit Queue 1    ::::: " + message.getMsg());
    }

    @RabbitListener(queues = "rabbitQueueQ")
    public void receiver2(HelloMessage message) {
        System.out.println(" Rabbit Queue 2    ::::: " + message.getMsg());
    }

    @RabbitListener(queues = "#{rabbitQueueT1.name}")
    public void receiverT(HelloMessage message) {
        System.out.println(" Rabbit Topic 1    ::::: " + message.getMsg());
    }

    @RabbitListener(queues = "#{rabbitQueueT2.name}")
    public void receiver2T(HelloMessage message) {
        System.out.println(" Rabbit Topic 2    ::::: " + message.getMsg());
    }


}
