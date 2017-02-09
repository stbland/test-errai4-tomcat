package org.stbland.test.errai4.server.dao;

import java.util.List;
import org.stbland.test.errai4.client.shared.Person;

public interface PersonDao {

    List<Person> findAll();
}
