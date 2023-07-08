package com.infosys.gcp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.integration.AckMode;
import com.google.cloud.spring.pubsub.integration.inbound.PubSubInboundChannelAdapter;
import com.google.cloud.spring.pubsub.support.BasicAcknowledgeablePubsubMessage;

@Configuration
public class PubSubConfig {
    
    @Bean
    public MessageChannel pubsubInputChannel() {
        return new DirectChannel();
    }
    @Beans
    public PubSubInboundChannelAdapter messageChannelAdapter(
            PubSubTemplate pubSubTemplate,
            MessageChannel pubsubInputChannel) {
        PubSubInboundChannelAdapter adapter = new PubSubInboundChannelAdapter(pubSubTemplate, "projects/gcds-oht33182u6-2023/topics/bmw_application-sub");
        adapter.setOutputChannel(pubsubInputChannel);
        adapter.setAckMode(AckMode.MANUAL);
        return adapter;
    }

    @Bean
    public IntegrationFlow inboundFlow(MessageChannel pubsubInputChannel) {
        return IntegrationFlows.from(pubsubInputChannel)
                .handle("messageHandler", "processMessage")
                .get();
    }

    @Bean
    @ServiceActivator(inputChannel = "pubsubInputChannel")
    public MessageHandler messageHandler() {
        return message -> {s
            BasicAcknowledgeablePubsubMessage originalMessage =
                    (BasicAcknowledgeablePubsubMessage) message.getPayload();
            System.out.println("Received message: " + new String(originalMessage.getPubsubMessage().getPayload()));
            originalMessage.ack();
        };
    }
}

