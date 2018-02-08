package org.stbland.test.errai4.client.shared;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/person")
public interface PersonService {

    @GET
    @Produces("application/json")
    List<Person> findAll(); 
    
    boolean isDaoOk();

}
