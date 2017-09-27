import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;

public class HelloWorldSpringDI {
    public static void main(String[] args) {
//        try (OutputStream out = new FileOutputStream(new File("META-INF/spring/app-context1.xml"))) {
//            out.write("fds".getBytes());
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        ApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");
        MessageRenderer mr = (MessageRenderer) ctx.getBean("renderer");
        mr.render();
    }
}
