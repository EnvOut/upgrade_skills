package com.tow.spring.annotation;

import com.tow.spring.MessageProvider;
import com.tow.spring.MessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("messageReaderer")
public class StandardOutMessageReaderer implements MessageRenderer {
    private MessageProvider messageProvider;
    @Override
    public void render() {
        if (messageProvider == null){
            throw new RuntimeException("RE");
        }
        System.out.println(messageProvider.getMessage());
    }

    @Override
    @Autowired
    public void setMessageProvider(MessageProvider provider) {
this.messageProvider=provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return messageProvider;
    }
}
