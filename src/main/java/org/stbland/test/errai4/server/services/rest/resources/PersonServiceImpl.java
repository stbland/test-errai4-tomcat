package org.stbland.test.errai4.server.services.rest.resources;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Path;
import org.stbland.test.errai4.client.shared.Person;
import org.stbland.test.errai4.client.shared.PersonService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/person")
public class PersonServiceImpl implements PersonService {

    final Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

    public PersonServiceImpl() {
        logger.debug("PersonServiceImpl constructor");
    }

    // @GET
    // @Produces("application/json")
    @Override
    public List<Person> findAll() {
        logger.debug("PersonServiceImpl.findAll");
        List<Person> personList = new ArrayList<Person>(2);
        personList.add(new Person("Richard", "Stallman"));
        personList.add(new Person("Linus", "Torvalds"));
        return personList;
    }

}
