package mx.com.interware.ssync.common.infrastructure.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import mx.com.interware.ssync.logs.domain.model.LogEvent;

@EnableKafka
@Configuration
public class KafkaConfig {

	/**
	 * Attribbute bootstrapServers.
	 */
	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapServers;

	/**
	 * Attribbute consumerGroup.
	 */
	@Value("${spring.kafka.consumer-group}")
	private String consumerGroup;

	@Bean
	public ConsumerFactory<String, LogEvent> consumerFactory() {
		Map<String, Object> config = new HashMap<>();

		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		config.put(ConsumerConfig.GROUP_ID_CONFIG, consumerGroup);
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		config.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
		config.put("security.protocol", "SASL_SSL");
		config.put("ssl.truststore.location", "/certs/one-click-ssl/kafka.truststore.jks");
		config.put("ssl.truststore.password", "TRUSTORE_PASSWORD");
		config.put("sasl.mechanism", "SCRAM-SHA-256");
		config.put("sasl.jaas.config", "org.apache.kafka.common.security.scram.ScramLoginModule required username=\"USERNAME_KAFKA\" password=\"PASSWORD_KAFKA\";");


		return new DefaultKafkaConsumerFactory(config, new StringDeserializer(),
				new JsonDeserializer<>(LogEvent.class));
	}

	@Bean
	public ProducerFactory<String, LogEvent> producerFactory() {
		Map<String, Object> config = new HashMap<>();

		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

		config.put("security.protocol", "SASL_SSL");
		config.put("ssl.truststore.location", "/certs/one-click-ssl/kafka.truststore.jks");
		config.put("ssl.truststore.password", "TRUSTORE_PASSWORD");
		config.put("sasl.mechanism", "SCRAM-SHA-256");
		config.put("sasl.jaas.config", "org.apache.kafka.common.security.scram.ScramLoginModule required username=\"USERNAME_KAFKA\" password=\"PASSWORD_KAFKA\";");

		return new DefaultKafkaProducerFactory<>(config);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, LogEvent> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, LogEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

	@Bean
	public KafkaTemplate kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}
}
