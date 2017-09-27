import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MessageSupportFactory {
    private static MessageSupportFactory instance;

    static {
        instance = new MessageSupportFactory();
    }

    private Properties props;
    private MessageRenderer renderer;
    private MessageProvider provider;

    private MessageSupportFactory() {
        props = new Properties();


        try (InputStream is = new FileInputStream("src/main/resources/msf.props")) {
            props.load(is);

            String rendererClassName = props.getProperty("renderer.class", "StandartOutMessageRenderer").toString();
            String providerClassName = props.getProperty("provider.class","HelloWorldMessageProvider").toString();

            renderer = (MessageRenderer) Class.forName(rendererClassName).newInstance();
            provider = (MessageProvider) Class.forName(providerClassName).newInstance();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static MessageSupportFactory getInstance() {
        return instance;
    }

    public MessageRenderer getRenderer() {
        return renderer;
    }

    public MessageProvider getProvider() {
        return provider;
    }
}
