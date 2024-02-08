package mx.com.interware.ssync.logs.domain.outgoing;

import mx.com.interware.ssync.logs.domain.model.EsEvent;

/**
 * Outgoing port EventsPort.
 * 
 * @author Interware
 *
 */
public interface EventsPort {

	/**
	 * Stores an event.
	 * 
	 * @param event the event
	 * @return the stored event.
	 */
	EsEvent save(EsEvent event);

}
