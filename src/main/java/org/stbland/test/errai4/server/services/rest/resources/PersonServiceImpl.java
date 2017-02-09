package org.stbland.test.errai4.server.services.rest.resources;

import java.util.List;
import javax.ws.rs.Path;
import org.stbland.test.errai4.client.shared.Person;
import org.stbland.test.errai4.client.shared.PersonService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.stbland.test.errai4.server.dao.PersonDao;
import org.stbland.test.errai4.server.dao.impl.PersonDaoMemoryImpl;

@Path("/person")
public class PersonServiceImpl implements PersonService {

    final Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

    private PersonDao personDao;

    public PersonServiceImpl() {
        logger.debug("PersonServiceImpl constructor");
        personDao = new PersonDaoMemoryImpl();
    }

    @Override
    public List<Person> findAll() {
        logger.debug("PersonServiceImpl.findAll");
        return personDao.findAll();
    }

}
