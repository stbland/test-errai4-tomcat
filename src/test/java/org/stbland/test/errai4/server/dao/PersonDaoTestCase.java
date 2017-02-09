package org.stbland.test.errai4.server.dao;

import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.stbland.test.errai4.client.shared.Person;
import org.stbland.test.errai4.server.dao.impl.PersonDaoMemoryImpl;

public class PersonDaoTestCase {

    private PersonDao personDao;

    @Before
    public void init() {
        personDao = new PersonDaoMemoryImpl();
    }

    @Test
    public void findAll() {
        final List<Person> personList = personDao.findAll();
        Assert.assertNotNull(personList);
        Assert.assertEquals(2, personList.size());

    }

}
