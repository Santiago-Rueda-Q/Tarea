package src;

class UserValidationException extends Exception {
    public UserValidationException(String message) {
        super(message);
    }
}

class UserCreationException extends Exception {
    public UserCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
