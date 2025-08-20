package src;

public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        
        System.out.println("1. Caso exitoso:");
        userManager.createUser("Juan Pérez", "juan@buou.com", "123456789");
        
        System.out.println("\n2. Error de validacion:");
        userManager.createUser("J", "juan@ninpn.com", "123456789");
        
        System.out.println("\n3. Email invalido:");
        userManager.createUser("Juan", "email-malo", "123456789");
        
        System.out.println("\n4. Password debil:");
        userManager.createUser("Juan", "juan@nii.com", "123");
    }
}