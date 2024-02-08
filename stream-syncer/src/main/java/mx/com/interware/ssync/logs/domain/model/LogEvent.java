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
public class LogEvent implements Serializable {

	/**
	 * Attribute serialVersionUID.
	 */
	private static final long serialVersionUID = 4139578224492750041L;

	/**
	 * Attribute id.
	 */
	private String id;

	/**
	 * Attribute logTs.
	 */
	private Date logTs;

	/**
	 * Attribute receptionTs.
	 */
	private Date receptionTs;

	/**
	 * Attribute system.
	 */
	private String system;

	/**
	 * Attribute hostName.
	 */
	private String hostName;

	/**
	 * Attribute source.
	 */
	private String source;

	/**
	 * Attribute logMessage.
	 */
	private String logMessage;

}
