package mx.com.interware.ssync.logs.domain.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "log_events")
public class EsEvent implements Serializable {

	/**
	 * Attribute serialVersionUID.
	 */
	private static final long serialVersionUID = -7878072533589223096L;

	/**
	 * Attribute id.
	 */
	@Id
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
