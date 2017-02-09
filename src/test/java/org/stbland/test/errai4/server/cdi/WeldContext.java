package org.stbland.test.errai4.server.cdi;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class WeldContext {

    private final WeldContainer weldContainer;

    private WeldContext() {
        final Weld weld = new Weld();
        this.weldContainer = weld.initialize();
    }

    public static WeldContext getInstance() {
        return WeldContext.Instance.SINGLETON;
    }

    private static final class Instance {

        static final WeldContext SINGLETON = new WeldContext();
    }

    public <T> T getBean(final Class<T> type) {
        return this.weldContainer.instance()
                .select(type)
                .get();
    }
}