package src;

class UserValidator {
    
    public void validate(String name, String email, String password) throws UserValidationException {
        if (name == null || name.trim().length() < 2) {
            throw new UserValidationException("Nombre inválido");
        }
        
        if (email == null || !email.contains("@") || !email.contains(".")) {
            throw new UserValidationException("Email inválido");
        }
        
        if (password == null || password.length() < 8 || !password.matches(".*[0-9].*")) {
            throw new UserValidationException("Password inválido");
        }
    }
}