package domain.Service;

import domain.model.ClaimDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import port.out.ClaimEventPublisher;

import java.util.concurrent.CompletableFuture;

@Component
public class EventPublisher implements ClaimEventPublisher {
    String topic="Claim-submit";

    @Override
    public CompletableFuture<SendResult<String, String>> sendToKafka(ClaimDto message){
        KafkaTemplate kafkaTemplate=new KafkaTemplate();
        return kafkaTemplate.send(topic,message);
    }


}
