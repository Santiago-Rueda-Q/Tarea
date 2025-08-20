# 🔧 Refactorización UserManager - Principios SOLID

## 📋 Descripción de la tarea

Este proyecto demuestra la refactorización de un código monolítico aplicando principios **SOLID**, **DRY**, **KISS** y **Fail Fast**. Se transformó una clase `UserManager` problemática en un sistema modular y mantenible.

---

## 🏗️ Estructura del Proyecto

```
└── 📁 src/
    ├── ☕ Main.java
    ├── ☕ User.java
    ├── ☕ UserException.java
    ├── ☕ UserManager.java
    ├── ☕ UserService.java
    └── ☕ UserValidator.java
```

---

## ❌ Problemas Identificados en el Código Original

### **Violaciones de Principios:**
- **SRP Violado**: Una clase manejaba validación + creación + notificación + logging
- **Código Duplicado**: Validaciones repetitivas y hardcodeadas
- **Sin Manejo de Errores**: Uso de `return void` en lugar de excepciones
- **I/O Primitivo**: `System.out.println()` para logging
- **Alto Acoplamiento**: Toda la lógica mezclada en una sola clase
- **Fail Silencioso**: Errores no se propagaban correctamente

### **Código Original Problemático:**
```java
❌ public class UserManager {
    public void createUser(String name, String email, String password) {
        if(name == null || name.isEmpty()) {
            System.out.println("Error: Nombre vacío");
            return; // ❌ Falla silenciosa
        }
        if(name.length() < 2) {
            System.out.println("Error: Nombre muy corto");
            return; // ❌ Duplicación de lógica
        }
        // ... más validaciones repetitivas
        // ❌ Múltiples responsabilidades mezcladas
    }
}
```

---

## ✅ Solución Implementada

### **Principios SOLID Aplicados:**

#### 🎯 **SRP (Single Responsibility Principle)**
- **`UserValidator`**: Solo valida datos de entrada
- **`UserService`**: Solo maneja lógica de negocio  
- **`UserManager`**: Solo coordina operaciones
- **`User`**: Solo representa el modelo de datos
- **`UserException`**: Solo maneja errores específicos

#### 🔄 **OCP (Open/Closed Principle)**
- Fácil extensión sin modificar código existente
- Nuevas validaciones se agregan sin cambios en otras clases

#### 🔄 **Otros Principios:**
- **DRY**: Validaciones centralizadas, eliminando duplicación
- **KISS**: Lógica simple y clara en cada clase
- **Fail Fast**: Validaciones tempranas con excepciones apropiadas

---

## 📁 Descripción de Archivos

### **`User.java`**
```java
// Modelo simple de datos
public class User {
    private String name, email, password;
    // Constructor, getters, setters, toString()
}
```

### **`UserException.java`**
```java
// Excepción personalizada para manejo profesional de errores
public class UserException extends Exception {

}
```

### **`UserValidator.java`**
```java
// Solo validar datos
public class UserValidator {
    public void validate(String name, String email, String password) throws UserException {

    }
}
```

### **`UserService.java`**
```java
// Solo lógica de negocio
public class UserService {
    public User createUser(...) throws UserException {
        // Validar usando UserValidator
        // Crear User
        // Simular persistencia y notificaciones
    }
}
```

### **`UserManager.java`**
```java
// ✅ SRP: Solo coordinar y manejar errores
public class UserManager {
    public void createUser(...) {
        try {
            // Delegar al UserService
        } catch (UserException e) {
            // Manejo profesional de errores
        }
    }
}
```

### **`Main.java`**
```java
// Demostración de la refactorización
public class Main {
    // Casos de prueba: exitoso, errores de validación
}
```

---

## 🚀 Cómo Ejecutar
### **Descargar la extension en visual studio code:**
```
Extension Pack for Java
```

### **Compilar:**
```
javac src/*.java
```

### **Ejecutar:**
```
java src.Main
```

### **Salida Esperada:**
```
1. Caso exitoso:
✅ Usuario creado: Juan Pérez
✅ Email enviado a: juan@buou.com
✅ Log: Usuario Juan Pérez creado

2. Error de validacion:
❌ Error: Nombre inválido

3. Email invalido:
❌ Error: Email inválido

4. Password debil:
❌ Error: Password inválido
```

---

## 📊 Comparación Antes/Después

| **Aspecto** | **❌ Antes** | **✅ Después** |
|-------------|--------------|----------------|
| **Clases** | 1 clase monolítica | 6 clases especializadas |
| **Responsabilidades** | Todo mezclado | SRP aplicado |
| **Validaciones** | Código duplicado | Centralizadas (DRY) |
| **Manejo de errores** | `return void` silencioso | `UserException` profesional |
| **Mantenibilidad** | Difícil de modificar | Modular y escalable |
| **Testabilidad** | Imposible testear partes | Cada clase testeable |

---

> 💡 **Lección aprendida**: Un buen diseño no requiere complejidad excesiva, solo separación clara de responsabilidades.
