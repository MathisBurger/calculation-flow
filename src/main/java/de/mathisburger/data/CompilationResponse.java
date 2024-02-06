package de.mathisburger.data;

/**
 * Response that is sent as JSON after configuration
 */
public class CompilationResponse {

    /**
     * Indicates the success state
     */
    public final boolean success;

    /**
     * Contains an error message
     */
    public final String message;

    public CompilationResponse(boolean successful, String message) {
        this.success = successful;
        this.message = message;
    }
}
