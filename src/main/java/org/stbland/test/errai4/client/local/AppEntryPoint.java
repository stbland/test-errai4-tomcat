package org.stbland.test.errai4.client.local;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import javax.annotation.PostConstruct;
import org.jboss.errai.bus.client.api.base.MessageBuilder;
import org.jboss.errai.bus.client.api.messaging.Message;
import org.jboss.errai.bus.client.api.messaging.MessageBus;
import org.jboss.errai.bus.client.api.messaging.MessageCallback;
import org.jboss.errai.common.client.protocols.MessageParts;
import org.jboss.errai.ioc.client.api.EntryPoint;

@EntryPoint
public class AppEntryPoint {

    @Inject
    private MessageBus messageBus;

    private final Label statusLabel = new Label();
    private final TextBox messageTextBox = new TextBox();

    @PostConstruct
    public void onLoad() {
        final Widget view = buildView();
        RootPanel.get().add(view);
    }

    private Widget buildView() {
        final Button sendMessageButton = new Button("Send");

        final Panel view = new VerticalPanel();
        view.add(new Label("Message:"));
        view.add(messageTextBox);
        view.add(sendMessageButton);
        view.add(new Label("Status:"));
        view.add(statusLabel);

        sendMessageButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                sendMessage();
            }
        }
        );

        return view;
    }

    private void sendMessage() {
        final String messageText = messageTextBox.getText();
        if ("".equals(messageText)) {
            setStatus("message is mandatory");
            messageTextBox.setFocus(true);
            return;
        }
        setStatus("sending message ...");

        MessageBuilder.createMessage()
                .toSubject("HelloWorldService")
                .withValue(messageText)
                .done()
                .repliesTo(new MessageCallback() {
                    public void callback(Message message) {
                        setStatus("Response from server: " + message.get(String.class, MessageParts.Value));
                    }
                })
                .sendNowWith(messageBus);
    }

    private void setStatus(String status) {
        statusLabel.setText(status);
    }

}
