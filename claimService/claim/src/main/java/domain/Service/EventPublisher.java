package domain.Service;

import domain.model.ClaimDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import port.out.ClaimEventPublisher;

import java.util.concurrent.CompletableFuture;

@Component
public class EventPublisher implements ClaimEventPublisher {

    String topic="Claim-submit";
    @Autowired
    private KafkaTemplate<String, ClaimDto> kafkaTemplate;

    @Override
    public CompletableFuture<SendResult<String, ClaimDto>> sendToKafka(ClaimDto message){
//        KafkaTemplate kafkaTemplate=new KafkaTemplate();
        return kafkaTemplate.send(topic,message);
    }


}
