package com.stackroute.nlp.config;



import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import com.stackroute.nlp.domain.PoS;



@Configuration
@EnableKafka
public class KafkaConsumerConfig {
      

    @Bean
    public Map<String, Object> consumerconfigs() {
        Map<String, Object> props = new HashMap<String, Object>();
        props.put(
          ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
          "172.23.238.178:9092");
        props.put(
          ConsumerConfig.GROUP_ID_CONFIG,
          "group1");
        props.put(
          ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
          StringDeserializer.class);
        props.put(
          ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
          JsonDeserializer.class);
        return props;
};
//props,null, new JsonDeserializer<ResultList>(ResultList.class)

@Bean
public ConsumerFactory<String, PoS> consumerFactory() {
    return new DefaultKafkaConsumerFactory<String, PoS>(consumerconfigs(),null, new JsonDeserializer< PoS>( PoS.class));
}

   @Bean
    public ConcurrentKafkaListenerContainerFactory<String, PoS>
      kafkaListenerContainerFactory() {
    
       ConcurrentKafkaListenerContainerFactory<String, PoS> factory
          = new ConcurrentKafkaListenerContainerFactory<String, PoS>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
    
//   @Bean
//    public Listener listener() {
//        return new Listener();
//    }
    
}