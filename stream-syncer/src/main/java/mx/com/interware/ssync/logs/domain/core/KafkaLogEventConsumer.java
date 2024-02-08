package mx.com.interware.ssync.logs.domain.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.com.interware.ssync.logs.domain.model.EsEvent;
import mx.com.interware.ssync.logs.domain.model.LogEvent;
import mx.com.interware.ssync.logs.domain.outgoing.EventsPort;

@Service
@Slf4j
public class KafkaLogEventConsumer {

	@Autowired
	private EventsPort eventsPort;

	/**
	 * Converts a log event into an es event.
	 * 
	 * @param logEvent log event.
	 * @return ES event.
	 */
	private EsEvent convert(LogEvent logEvent) {
		EsEvent esEvent = EsEvent.builder()
				.logMessage(logEvent.getLogMessage())
				.logTs(logEvent.getLogTs())
				.system(logEvent.getSystem())
				.source(logEvent.getSource())
				.hostName(logEvent.getHostName())
				.receptionTs(logEvent.getReceptionTs())
				.build();
		return esEvent;
	}

	/**
	 * Consumes a log event converts and put it into ES.
	 * 
	 * @param logEvent log event.
	 */
	@KafkaListener(topics = "${kafka.topics.log_events_topic}", groupId = "${kafka.topics.group_id}")
	public void consume(LogEvent logEvent) {

		EsEvent esEvent = convert(logEvent);

		log.info("=============== Received Message: " + logEvent);
		log.info("=============== esEvent         : " + esEvent);

		eventsPort.save(esEvent);
	}
}
