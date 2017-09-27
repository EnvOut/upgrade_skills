import java.util.logging.Logger;

public class StandartOutMessageRenderer implements MessageRenderer {
    private static Logger log = Logger.getLogger("StandartOutMessageRenderer");
    private MessageProvider messageProvider;

    @Override
    public void render() {
        if (messageProvider == null) {
            throw new RuntimeException("RE");
        }
        log.info(messageProvider.getMessage());
    }

    @Override
    public MessageProvider getMessageProvider() {
        return messageProvider;
    }

    @Override
    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;
    }
}
