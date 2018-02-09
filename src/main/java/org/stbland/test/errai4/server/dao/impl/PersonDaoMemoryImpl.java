package org.stbland.test.errai4.server.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.stbland.test.errai4.client.shared.Person;
import org.stbland.test.errai4.server.dao.PersonDao;

@ApplicationScoped
@Default
public class PersonDaoMemoryImpl implements PersonDao {

    final Logger logger = LoggerFactory.getLogger(PersonDaoMemoryImpl.class);

    private static final Map<Integer, Person> personByIdMap = new ConcurrentHashMap<Integer, Person>(10);

    static {
        personByIdMap.put(0, new Person(0, "Richard", "Stallman"));
        personByIdMap.put(1, new Person(1, "Linus", "Torvalds"));
        personByIdMap.put(2, new Person(2, "Anders", "Hejlsberg"));
        personByIdMap.put(3, new Person(3, "Bjarne", "Stroustrup"));
    }

    public PersonDaoMemoryImpl() {
    }

    @Override
    public List<Person> findAll() {
        logger.debug("PersonDaoMemoryImpl.findAll");
        final List<Person> personList = new ArrayList<Person>(personByIdMap.size());
        personList.addAll(personByIdMap.values());
        return personList;
    }

}
