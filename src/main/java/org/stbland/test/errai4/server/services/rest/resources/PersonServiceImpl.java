package org.stbland.test.errai4.server.services.rest.resources;

import java.util.List;
import javax.enterprise.inject.Default;
import javax.enterprise.context.ApplicationScoped;
// import javax.inject.Inject;
import javax.ws.rs.Path;
import org.stbland.test.errai4.client.shared.Person;
import org.stbland.test.errai4.client.shared.PersonService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.stbland.test.errai4.server.dao.PersonDao;
import org.stbland.test.errai4.server.dao.impl.PersonDaoMemoryImpl;

@Path("/person")
// @ApplicationScoped
// @Default
public class PersonServiceImpl implements PersonService {

    final Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

    // @Inject
    private PersonDao personDao;

    public PersonServiceImpl() {
        logger.debug("PersonServiceImpl constructor");
        setPersonDao( new PersonDaoMemoryImpl() );
    }

    public PersonServiceImpl(PersonDao personDao) {
        logger.debug("PersonServiceImpl constructor(personDao)");
        this.personDao = personDao;
    }
    
    @Override
    public boolean isDaoOk() {
        return personDao != null;
    }
    

    @Override
    public List<Person> findAll() {
        logger.debug("PersonServiceImpl.findAll");
        return personDao.findAll();
    }

  // @Inject
   public void setPersonDao(PersonDao personDao) {
        logger.debug("PersonServiceImpl.setPersonDao called");
        this.personDao = personDao;
    }

}
