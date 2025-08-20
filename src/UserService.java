package src;

class UserService {
    private UserValidator validator = new UserValidator();
    
    public void createUser(String name, String email, String password) throws UserValidationException {
        validator.validate(name, email, password);
        
        System.out.println("Usuario creado: " + name);
                
        System.out.println("Email enviado a: " + email);
        
        System.out.println("Log: Usuario " + name + " creado");
    }
}