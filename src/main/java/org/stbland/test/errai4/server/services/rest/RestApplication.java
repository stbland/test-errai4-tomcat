package org.stbland.test.errai4.server.services.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class RestApplication extends ResourceConfig {

    public RestApplication() {
        packages("org.stbland.test.errai4.server.services.rest.resources");
    }

}
