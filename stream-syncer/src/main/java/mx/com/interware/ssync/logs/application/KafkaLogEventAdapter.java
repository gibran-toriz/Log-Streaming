package mx.com.interware.ssync.logs.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import mx.com.interware.ssync.logs.domain.incomming.SendEventsUseCase;
import mx.com.interware.ssync.logs.domain.model.LogEvent;

/**
 * Adapter for TodoService.
 * 
 * @author Interware
 *
 */
@Slf4j
@Component
public class KafkaLogEventAdapter {

	/**
	 * Port sendEventsUseCase.
	 */
	@Autowired
	private SendEventsUseCase sendEventsUseCase;

	/**
	 * Send messages to a topic.
	 * 
	 * @param event the event.
	 */
	public void sendLogEvent(LogEvent event) {
		log.info("Executing (sendLogEvent) in adapter ...");
		sendEventsUseCase.sendLogEvent(event);
		log.info("(sendLogEvent) in adapter executed.");
	}

}
