package org.stbland.test.errai4.server.services.rest.resources;

import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.stbland.test.errai4.client.shared.Person;
import org.stbland.test.errai4.client.shared.PersonService;
import org.stbland.test.errai4.server.dao.impl.PersonDaoMemoryImpl;

public class PersonServiceTestCase {

    private PersonService personService;

    @Before
    public void init() {
        personService = new PersonServiceImpl(new PersonDaoMemoryImpl());        
    }

    @Test
    public void findAll() {
        final List<Person> personList = personService.findAll();
        Assert.assertNotNull(personList);
        Assert.assertEquals(3, personList.size());
    }

}
