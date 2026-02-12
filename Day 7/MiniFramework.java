import java.lang.annotation.*;
import java.lang.reflect.Method;

// 1. Custom Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

// 2. Singleton Logger (Bonus)
class Logger {
    private static Logger instance;
    private Logger() {}
    public static Logger getInstance() {
        if (instance == null) instance = new Logger();
        return instance;
    }
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}

// 3. Abstraction (Interfaces)
interface Service { void execute(); }

// 4. Services
class OrderService implements Service {
    @LogExecutionTime
    public void execute() {
        try { Thread.sleep(50); } catch (InterruptedException e) {}
        Logger.getInstance().log("Order Processed");
    }
}

class UserService implements Service {
    @LogExecutionTime
    public void createUser() {
        try { Thread.sleep(30); } catch (InterruptedException e) {}
        Logger.getInstance().log("User Created");
    }
    public void execute() {} // Unannotated
}

// 5. Framework - Reflection to detect & measure
public class MiniFramework {
    public static void main(String[] args) throws Exception {
        Object[] services = {new OrderService(), new UserService()};

        for (Object service : services) {
            Method[] methods = service.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(LogExecutionTime.class)) {
                    long start = System.currentTimeMillis();
                    method.invoke(service);
                    long end = System.currentTimeMillis();
                    Logger.getInstance().log(method.getName() + " took " + (end - start) + "ms");
                }
            }
        }
    }
}
