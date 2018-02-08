package org.stbland.test.errai4.server.services.rest.resources;

import java.util.List;
import javax.inject.Inject;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.stbland.test.errai4.client.shared.Person;
import org.stbland.test.errai4.client.shared.PersonService;
import org.stbland.test.errai4.server.cdi.WeldJUnit4Runner;

@RunWith(WeldJUnit4Runner.class)
public class PersonServiceCdiTestCase {

    @Inject
    protected PersonService personService;

    public PersonServiceCdiTestCase() {
        this.personService = null;
    }

    @Test
    public void cdiInjectedNotNull() {
        Assert.assertNotNull(personService);
    }

    @Test
    public void cdiInjectedName() {
        Assert.assertThat(personService, Matchers.instanceOf(PersonServiceImpl.class));
    }
    
    @Test
    public void daoOk() {
        Assert.assertTrue("requis : dao not null", personService.isDaoOk());
    }

    @Test
    public void findAll() {
        final List<Person> personList = personService.findAll();
        Assert.assertNotNull(personList);
        Assert.assertEquals(3, personList.size());
    }

}
