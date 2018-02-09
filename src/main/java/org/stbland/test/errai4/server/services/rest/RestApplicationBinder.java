package org.stbland.test.errai4.server.services.rest;

import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.stbland.test.errai4.client.shared.PersonService;
import org.stbland.test.errai4.server.services.rest.resources.PersonServiceImpl;

public class RestApplicationBinder extends AbstractBinder
{

  @Override
  protected void configure()
  {
    bind(PersonService.class).to(PersonServiceImpl.class);
  }

}
