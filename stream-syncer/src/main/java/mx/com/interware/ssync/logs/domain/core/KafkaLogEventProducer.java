package mx.com.interware.ssync.logs.domain.core;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.com.interware.ssync.logs.domain.incomming.SendEventsUseCase;
import mx.com.interware.ssync.logs.domain.model.LogEvent;

/**
 * Used to produce event log messages.
 */
@Service
@Slf4j
public class KafkaLogEventProducer implements SendEventsUseCase {

	/**
	 * Attribute kafkaTemplate.
	 */
	@Autowired
	private KafkaTemplate<String, LogEvent> kafkaTemplate;

	/**
	 * Attribute logEventsTopic.
	 */
	@Value("${kafka.topics.log_events_topic}")
	private String logEventsTopic;

	/**
	 * Send messages to a topic.
	 * 
	 * @param event the event.
	 * @param topic the topic.
	 */
	private void sendEvent(LogEvent event, String topic) {
		Date date = new Date();
		event.setReceptionTs(date);
		log.info("topic: " + topic);
		log.info("event: " + event);

		kafkaTemplate.send(topic, event);
	}

	/**
	 * Send messages to a topic.
	 * 
	 * @param event the event.
	 */
	@Override
	public void sendLogEvent(LogEvent event) {
		sendEvent(event, logEventsTopic);
	}

}
