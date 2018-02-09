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
import com.google.gwt.http.client.Request;
import com.google.inject.Inject;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import org.jboss.errai.bus.client.api.base.MessageBuilder;
import org.jboss.errai.bus.client.api.messaging.Message;
import org.jboss.errai.bus.client.api.messaging.MessageBus;
import org.jboss.errai.bus.client.api.messaging.MessageCallback;
import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.common.client.api.ErrorCallback;
import org.jboss.errai.common.client.api.RemoteCallback;
import org.jboss.errai.common.client.protocols.MessageParts;
import org.jboss.errai.enterprise.client.jaxrs.api.ResponseException;
import org.jboss.errai.enterprise.client.jaxrs.api.RestClient;
import org.jboss.errai.enterprise.client.jaxrs.api.RestErrorCallback;
import org.jboss.errai.ioc.client.api.EntryPoint;
import org.stbland.test.errai4.client.shared.Person;
import org.stbland.test.errai4.client.shared.PersonService;

@EntryPoint
public class AppEntryPoint {

    @Inject
    private MessageBus messageBus;

    @Inject
    private Caller<PersonService> personServiceCaller;

    private final Label statusLabel = new Label();
    private final TextBox messageTextBox = new TextBox();

    @PostConstruct
    public void onLoad() {
        final Widget view = buildView();
        RootPanel.get().add(view);
    }

    private Widget buildView() {
        final Button sendMessageButton = new Button("Send");
        final Button getPersonListButton = new Button("Get person's list from REST service");

        final Panel view = new VerticalPanel();
        view.add(new Label("Message:"));
        view.add(messageTextBox);
        view.add(sendMessageButton);
        view.add(getPersonListButton);
        view.add(new Label("Status:"));
        view.add(statusLabel);

        sendMessageButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                sendMessage();
            }
        }
        );

        getPersonListButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                getPersonList();
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
        setStatus("sending message from Errai Bus Client ...");

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

    private void getPersonList() {
        final RemoteCallback<List<Person>> successCallback = new RemoteCallback<List<Person>>() {

            public void callback(List<Person> personList) {
                final StringBuilder personListStringBuilder = new StringBuilder(250/*capacity*/);
                Person person;
                personListStringBuilder.append("[");
                for (Iterator<Person> iterator = personList.iterator(); iterator.hasNext();) {
                    person = iterator.next();
                    personListStringBuilder.append(person.getFirstName());
                    personListStringBuilder.append(" ");
                    personListStringBuilder.append(person.getLastName().toUpperCase());
                    if (iterator.hasNext()) {
                        personListStringBuilder.append(", ");
                    }
                }
                personListStringBuilder.append("]");
                setStatus("Response from server: " + personListStringBuilder.toString());

            }

        };

        final ErrorCallback errorCallback = new RestErrorCallback() {

            public boolean error(Request request, Throwable throwable) {
                setStatus("Response from server: " + throwable.getMessage());

                return false;

            }

        };

        setStatus("call REST service from Errai JAX-RS Client ...");
        personServiceCaller.call(successCallback, errorCallback).findAll();
    }

    private void setStatus(String status) {
        statusLabel.setText(status);
    }

}
