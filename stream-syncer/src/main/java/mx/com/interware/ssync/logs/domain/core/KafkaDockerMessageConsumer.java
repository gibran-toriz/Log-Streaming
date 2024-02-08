package mx.com.interware.ssync.logs.domain.core;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import mx.com.interware.ssync.logs.domain.model.EsEvent;
import mx.com.interware.ssync.logs.domain.model.LogMessage;
import mx.com.interware.ssync.logs.domain.outgoing.EventsPort;

@Service
public class KafkaDockerMessageConsumer {

	@Autowired
	private EventsPort eventsPort;

	/**
	 * Converts a log event into an es event.
	 * 
	 * @param logMessage log event.
	 * @return ES event.
	 */
	private EsEvent convert(LogMessage logMesasge) {
		EsEvent esLogMessage = EsEvent.builder()
				.hostName(logMesasge.getContainer_name())
				.logMessage(logMesasge.getLog())
				.source(logMesasge.getSource())
				.system("docker swarm")
				.receptionTs(logMesasge.getReceptionTs())
				.build();
		return esLogMessage;
	}

	/**
	 * Consumes a log message converts and put it into ES.
	 * 
	 * @param logMessage log event.
	 */
	@KafkaListener(topics = "logs_topic", groupId = "${kafka.topics.group_id}")
	public void consume(LogMessage logMessage) {
		Date date = new Date();
		logMessage.setReceptionTs(date);

		EsEvent esVent = convert(logMessage);

		System.out.println("··············· Received Message: " + logMessage);
		System.out.println("··············· esVent          : " + esVent);

		eventsPort.save(esVent);
	}
}
