import java.io.*;

public class HelloWorldDecouplet {
    public static void main(String[] args){
        MessageRenderer mr = MessageSupportFactory.getInstance().getRenderer();
        MessageProvider mp = MessageSupportFactory.getInstance().getProvider();
        mr.setMessageProvider(mp);
        mr.render();

    }
}
