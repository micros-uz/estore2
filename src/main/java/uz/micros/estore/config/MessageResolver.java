package uz.micros.estore.config;

import org.thymeleaf.Arguments;
import org.thymeleaf.messageresolver.IMessageResolver;
import org.thymeleaf.messageresolver.MessageResolution;

public class MessageResolver implements IMessageResolver {
    @Override
    public String getName() {
        return "eStoreMessageResolver";
    }

    @Override
    public Integer getOrder() {
        return 1;
    }

    @Override
    public MessageResolution resolveMessage(Arguments arguments, String s, Object[] objects) {
        //return new MessageResolution("\u0411\u043b\u043e\u0433");
        return new MessageResolution("Блог");
    }

    @Override
    public void initialize() {

    }
}
