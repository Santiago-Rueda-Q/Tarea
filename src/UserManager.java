package src;

public class UserManager {
    private UserService userService = new UserService();
    
    public void createUser(String name, String email, String password) {
        try {
            userService.createUser(name, email, password);
            
        } catch (UserValidationException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}