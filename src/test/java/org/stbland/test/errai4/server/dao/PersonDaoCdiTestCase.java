package org.stbland.test.errai4.server.dao;

import java.util.List;
import javax.inject.Inject;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.stbland.test.errai4.client.shared.Person;
import org.stbland.test.errai4.server.cdi.WeldJUnit4Runner;
import org.stbland.test.errai4.server.dao.impl.PersonDaoMemoryImpl;

@RunWith(WeldJUnit4Runner.class)
public class PersonDaoCdiTestCase {

    @Inject
    private PersonDao personDao;

    @Test
    public void cdiInjectedNotNull() {
        Assert.assertNotNull(personDao);
    }

    @Test
    public void cdiInjectedName() {
        Assert.assertThat(personDao, Matchers.instanceOf(PersonDaoMemoryImpl.class));
    }

    @Test
    public void findAll() {
        final List<Person> personList = personDao.findAll();
        Assert.assertNotNull(personList);
        Assert.assertEquals(3, personList.size());
    }

}
