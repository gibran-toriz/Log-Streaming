package mx.com.interware.ssync.logs.domain.outgoing;

import mx.com.interware.ssync.logs.domain.model.EsEvent;
import mx.com.interware.ssync.logs.domain.model.LogMessage;

/**
 * Outgoing port EventsPort.
 * 
 * @author Interware
 *
 */
public interface DockerMessagePort {

	/**
	 * Stores an message.
	 * 
	 * @param message the message
	 * @return the stored message.
	 */
	EsEvent save(LogMessage message);

}
