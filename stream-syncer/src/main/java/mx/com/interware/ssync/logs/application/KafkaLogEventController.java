package mx.com.interware.ssync.logs.application;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import mx.com.interware.ssync.logs.domain.model.LogEvent;

@RestController
@CrossOrigin(origins = "*")
@Tag(name = "LOGS")
@Slf4j
public class KafkaLogEventController {

	/**
	 * KafkaLogEventAdapter producer.
	 */
	@Autowired
	private KafkaLogEventAdapter producer;

	/**
	 * Used to register a log event.
	 * 
	 * @param event the event.
	 * @return the response.
	 */
	@Operation(summary = "Log event registration.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "" + HttpStatus.SC_ACCEPTED, description = "Robot event registration."),
			@ApiResponse(responseCode = ""
					+ HttpStatus.SC_BAD_REQUEST, description = "An error ocurred while registering event.") })
	@ResponseStatus(value = org.springframework.http.HttpStatus.ACCEPTED)
	@PostMapping("/registerLogEvent")
	public ResponseEntity<?> registerEvent(@RequestBody LogEvent event) {
		try {
			producer.sendLogEvent(event);
			return ResponseEntity.ok("OK");
		} catch (Exception e) {
			log.error("An error occurred while registering event : " + event, e);
			return ResponseEntity.internalServerError().body("An error occurred while registering event : " + event);
		}
	}

}
