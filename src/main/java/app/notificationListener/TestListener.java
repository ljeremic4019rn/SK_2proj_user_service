package app.notificationListener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Component
public class TestListener {

    private ObjectMapper objectMapper;

    public TestListener(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @JmsListener(destination = "${destination.testMessage}", concurrency = "5-10")
    public void listenForMessage(Message message) throws JMSException, JsonProcessingException {

        String json = ((TextMessage)message).getText();
        ActivationNotifDto dto = objectMapper.readValue(json,ActivationNotifDto.class);

        System.out.println("CITANJE PORUKE:");
        System.out.println(dto);

    }
}
