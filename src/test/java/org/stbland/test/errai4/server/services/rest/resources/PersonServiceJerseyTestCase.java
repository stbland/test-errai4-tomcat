package org.stbland.test.errai4.server.services.rest.resources;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.stbland.test.errai4.client.shared.Person;
import org.stbland.test.errai4.server.services.rest.RestApplication;

public class PersonServiceJerseyTestCase extends JerseyTest
{

  final Logger logger = LoggerFactory
      .getLogger(PersonServiceJerseyTestCase.class);

  @Override
  protected Application configure()
  {
    return new RestApplication();
  }

  @Test
  public void findAll_Response()
  {
    Response response = target("person").request().get();

    assertEquals("should return status 200", 200, response.getStatus());
    assertNotNull("Should return list of Person", response.getEntity());
  }

  @Test
  public void findAll_GenericType()
  {
    final List<Person> personList = target("person").request()
        .get(new GenericType<List<Person>>()
        {
        });

    assertNotNull(personList);
    logger.debug("findAll_GenericType personList.size: " + personList.size());
    assertEquals(4, personList.size());
  }
}
