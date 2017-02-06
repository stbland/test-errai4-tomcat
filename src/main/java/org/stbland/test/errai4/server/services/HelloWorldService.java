package org.stbland.test.errai4.server.services;

import org.jboss.errai.bus.client.api.base.MessageBuilder;
import org.jboss.errai.bus.client.api.messaging.Message;
import org.jboss.errai.bus.client.api.messaging.MessageCallback;
import org.jboss.errai.bus.server.annotations.Service;
import org.jboss.errai.common.client.protocols.MessageParts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class HelloWorldService implements MessageCallback {

    final Logger logger = LoggerFactory.getLogger(HelloWorldService.class);
    
    public HelloWorldService() {
        logger.debug("HelloWorldService constructor");
    }

    @Override
    public void callback(Message message) {
        final String messageText = message.get(String.class, MessageParts.Value);
        logger.debug("HelloWorldService.callback(message) messageText: " + messageText);

        MessageBuilder.createConversation(message)
                .subjectProvided()
                .withValue("message received: " + messageText)
                .done().reply();

    }

}
