package de.mathisburger.data;

public class CompilationResponse {

    public final boolean success;

    public final String message;

    public CompilationResponse(boolean successful, String message) {
        this.success = successful;
        this.message = message;
    }
}
