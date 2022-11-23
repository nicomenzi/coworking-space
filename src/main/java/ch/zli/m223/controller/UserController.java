package ch.zli.m223.controller;


import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces; 

import ch.zli.m223.model.Person;
import ch.zli.m223.service.UserService;

@Path("/register")
public class UserController {

    @Inject
    UserService userService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Person register(Person person) {
        return userService.createUser(person);
    }

    

    
    
    
}
