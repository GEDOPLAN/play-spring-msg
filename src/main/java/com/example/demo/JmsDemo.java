package com.example.demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsDemo {

    @JmsListener(destination = "demo", containerFactory = "topic")
    public void receiver(HelloMessage message){
        System.out.println("1    ::::: " + message.getMsg());
    }

    @JmsListener(destination = "demo", containerFactory = "topic")
    public void receiver2(HelloMessage message){
        System.out.println("2    ::::: " + message.getMsg());
    }

    @JmsListener(destination = "demo", containerFactory = "queue")
    public void receiverT(HelloMessage message){
        System.out.println("T1    ::::: " + message.getMsg());
    }

    @JmsListener(destination = "demo", containerFactory = "queue")
    public void receiver2T(HelloMessage message){
        System.out.println("T2    ::::: " + message.getMsg());
    }


}
