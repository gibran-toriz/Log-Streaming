package mx.com.interware.ssync.common.application.model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.AbstractResource;

import com.google.gson.Gson;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * DTO class used for error response.
 *
 * @author Interware
 *
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class ErrorResponseDTO extends AbstractResource {

    /**
     * Attribute for code.
     */
    private String code;

    /**
     * Attribute for message.
     */
    private String message;

    /**
     * Gets the DTO in JSON format.
     */
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    /**
     * Returns the description of the object.
     */
    @Override
    public String getDescription() {
        return this.toString();
    }

    /**
     * Gets the DTO stream in JSON format.
     */
    @Override
    public InputStream getInputStream() throws IOException {
        String json = this.toString();
        return new ByteArrayInputStream(json.getBytes());
    }

}
