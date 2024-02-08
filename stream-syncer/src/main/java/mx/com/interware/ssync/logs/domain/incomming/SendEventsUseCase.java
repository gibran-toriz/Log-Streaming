package mx.com.interware.ssync.logs.domain.incomming;

import mx.com.interware.ssync.logs.domain.model.LogEvent;

/**
 * Incomming port SendEventsUseCase.
 * 
 * @author Interware
 *
 */
public interface SendEventsUseCase {

	/**
	 * Send messages to a topic.
	 * 
	 * @param event the event.
	 */
	void sendLogEvent(LogEvent event);

}
