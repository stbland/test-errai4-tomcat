package org.stbland.test.errai4.client.local;

import com.google.gwt.user.client.Window;
import javax.annotation.PostConstruct;
import org.jboss.errai.ioc.client.api.EntryPoint;

@EntryPoint
public class AppEntryPoint {

    @PostConstruct
    public void onLoad() {

        Window.alert("Errai 4 works on Tomcat server");

    }
}
