package suleyman.JackPot.services.Auth.Response;

public class AuthErrorResponse {
    private int statusCode;
    private String[] message;

    public String[] getMessage() {
        return this.message;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
