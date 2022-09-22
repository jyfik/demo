package ru.jyfik.rabbitmqworkout.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.jyfik.rabbitmqworkout.RabbitProperties;

/**
 * @author Daniil Vlasov (vlasov.daniil@otr.ru)
 */
@Slf4j
@Configuration
@ComponentScan
@RequiredArgsConstructor
public class RabbitConfiguration {

    private final RabbitProperties properties;

    @Value("${spring.rabbitmq.template.routing-key:employee}")
    private String ROUTING_KEY;

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost", 5672);
        connectionFactory.setUsername(properties.getUsername());
        connectionFactory.setPassword(properties.getPassword());

        return connectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(this.connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(this.connectionFactory());
        template.setExchange("demo");

        return template;
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(properties.getTopic());
    }

    @Bean
    public Queue myQueue() {
        return QueueBuilder.durable("employee").build();
    }

    @Bean
    public Binding binding(Queue myQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(myQueue).to(topicExchange).with(ROUTING_KEY);
    }

}
