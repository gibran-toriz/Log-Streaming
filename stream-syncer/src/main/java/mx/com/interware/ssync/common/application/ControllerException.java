package mx.com.interware.ssync.common.application;

/**
 * Exception used in domain core services.
 * 
 * @author Interware
 *
 */
public class ControllerException extends RuntimeException {

    /**
     * Attribute for serialVersionUID.
     */
    private static final long serialVersionUID = -6361192883441463202L;

    /**
     * Constructor.
     * 
     * @param message Message
     */
    public ControllerException(final String message) {
        super(message);
    }

    /**
     * Constructor.
     * 
     * @param message Message
     * @param cause   Cause
     */
    public ControllerException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
