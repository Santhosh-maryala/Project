
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class JDKValidation{
    public static void main(String[] args) {
        
        JavaCompiler compiler =ToolProvider.getSystemJavaCompiler();

        if (compiler ==null){
            System.out.println("JDK not Detected");
            System.out.println("The server is running with a JRE only");
            System.out.println("A JRE can run java application but cannot compile them");
        }
        else
        {
            System.out.println("JDK detected successfully");
            System.out.println("This environmet supports java compilation");
        }
        System.out.println("\nExplanation:");
        System.out.println("JVM  : Executes Java bytecode.");
        System.out.println("JRE  : JVM + libraries (used to RUN applications).");
        System.out.println("JDK  : JRE + development tools like javac (used to COMPILE applications).");

    }
}
