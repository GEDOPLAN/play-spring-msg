package de.gedoplan.demo.jms;

import de.gedoplan.demo.HelloMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsDemo {

    @JmsListener(destination = "demo", containerFactory = "topic")
    public void receiver(HelloMessage message){
        System.out.println("JMS T1    ::::: " + message.getMsg());
    }

    @JmsListener(destination = "demo", containerFactory = "topic")
    public void receiver2(HelloMessage message){
        System.out.println("JMS T2    ::::: " + message.getMsg());
    }

    @JmsListener(destination = "demo", containerFactory = "queue")
    public void receiverT(HelloMessage message){
        System.out.println("JMS Q1    ::::: " + message.getMsg());
    }

    @JmsListener(destination = "demo", containerFactory = "queue")
    public void receiver2T(HelloMessage message){
        System.out.println("JMS Q2    ::::: " + message.getMsg());
    }


}
