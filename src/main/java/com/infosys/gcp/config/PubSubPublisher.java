package com.infosys.gcp.helper;

import org.springframework.stereotype.Component;

@Component
public class PubSubPublisher {
    private final PubSubTemplate pubSubTemplate;
    private final String topicName;

    public PubSubPublisher(PubSubTemplate pubSubTemplate) {
        this.pubSubTemplate = pubSubTemplate;
        this.topicName = "projects/gcds-oht33182u6-2023/topics/bmw_application";
    }

    public void publishMessage(String message) {
        pubSubTemplate.publish(topicName, message.getBytes());
    }
}
