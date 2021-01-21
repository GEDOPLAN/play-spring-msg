package de.gedoplan.demo.rabbit;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue rabbitQueueQ() {
        return new Queue("rabbitQueueQ");
    }

    @Bean
    public Queue rabbitQueueT1() {
        return new AnonymousQueue();
    }

    @Bean
    public Queue rabbitQueueT2() {
        return new AnonymousQueue();
    }

    @Bean
    DirectExchange exchangeDirect() {
        return new DirectExchange("exchangeDirect");
    }

    @Bean
    FanoutExchange exchangeFanout() {
        return new FanoutExchange("exchangeFanout");
    }

    @Bean
    Binding bindingQ(Queue rabbitQueueQ, DirectExchange exchangeDirect) {
        return BindingBuilder.bind(rabbitQueueQ).to(exchangeDirect).with("demo");
    }

    @Bean
    Binding bindT1(Queue rabbitQueueT1, FanoutExchange exchangeFanout) {
        return BindingBuilder.bind(rabbitQueueT1).to(exchangeFanout);
    }

    @Bean
    Binding bindT2(Queue rabbitQueueT2, FanoutExchange exchangeFanout) {
        return BindingBuilder.bind(rabbitQueueT2).to(exchangeFanout);
    }


}
