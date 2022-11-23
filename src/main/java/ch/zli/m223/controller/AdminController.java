package ch.zli.m223.controller;


import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.BuchungGeraet;
import ch.zli.m223.model.BuchungRaum;
import ch.zli.m223.model.Person;
import ch.zli.m223.service.AdminService;

@Path("/admin")
@Tag(name = "Admin", description = "Handling of Admin")
public class AdminController {

    @Inject
    AdminService adminService;

    @Path("/member")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "summary",
        description = "description"
    )
    public List<Person> getMember() {
        return adminService.getPersonen();
    }

    @Path("/member/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "summary",
        description = "description"
    )
    public void deleteMember(@PathParam("id") Long id) {
        adminService.deletePerson(id);
    }

    @Path("/member/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "summary",
        description = "description"
    )
    public Person updateMember(@PathParam("id") Long id, Person person) {
        person.setId(id);
        return adminService.updatePerson(person);
    }
    
//
    @Path("/buchungRaum/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "summary",
        description = "description"
    )
    public void deleteBuchungRaum(@PathParam("id") Long id) {
        adminService.deleteBuchungRaum(id);
    }

    @Path("/buchungRaum/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "summary",
        description = "description"
    )
    public BuchungRaum updateBuchungRaum(@PathParam("id") Long id, BuchungRaum buchungRaum) {
        buchungRaum.setId(id);
        return adminService.updateBuchungRaum(buchungRaum);
    }

    @Path("/buchungGeraet/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "summary",
        description = "description"
    )
    public void deleteBuchungGeraet(@PathParam("id") Long id) {
        adminService.deleteBuchungGeraet(id);
    }

    @Path("/buchungGeraet/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "summary",
        description = "description"
    )
    public BuchungGeraet updateBuchungGeraet(@PathParam("id") Long id, BuchungGeraet buchungGeraet) {
        buchungGeraet.setId(id);
        return adminService.updateBuchungGeraet(buchungGeraet);
    }





    
}
