package org.stbland.test.errai4.server.cdi;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

public class WeldJUnit4Runner extends BlockJUnit4ClassRunner {

    public WeldJUnit4Runner(Class<Object> clazz) throws InitializationError {
        super(clazz);
    }

    @Override
    protected Object createTest() {
        final Class<?> test = getTestClass().getJavaClass();
        return WeldContext.getInstance().getBean(test);
    }
}
