package mx.com.interware.ssync.logs.domain.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class LogMessage implements Serializable {

	/**
	 * Attribute serialVersionUID.
	 */
	private static final long serialVersionUID = -7778140065743449063L;

	/**
	 * Attribute id.
	 */
	private String id;

	/**
	 * Attribute container_id.
	 */
	private String container_id;

	/**
	 * Attribute container_name.
	 */
	private String container_name;

	/**
	 * Attribute source.
	 */
	private String source;

	/**
	 * Attribute log.
	 */
	private String log;

	/**
	 * Attribute receptionTs.
	 */
	private Date receptionTs;

}
