package exceptions;

class Exception {
    private String message;

    public Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
