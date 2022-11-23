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
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.BuchungGeraet;
import ch.zli.m223.model.BuchungRaum;
import ch.zli.m223.service.BuchungService;

@Path("/buchung")
@Tag(name = "Buchung", description = "Handling of Buchung")
@RolesAllowed({"Mitglied", "Administrator"})
public class BuchungController {
    
    @Inject
    BuchungService buchungService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Bucht ein Gerät",
        description = "description"
    )
    public BuchungRaum createBuchungRaum(BuchungRaum buchungRaum) {
        return buchungService.createBuchungRaum(buchungRaum);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Gibt alle Buchungen zurück",
        description = "description"
    )
    public List<BuchungRaum> getBuchungRaum() {
        return buchungService.getBuchungRaum();
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Löscht eine Buchung",
        description = "description"
    )
    public void deleteBuchungRaum(@PathParam("id") Long id) {
        buchungService.deleteBuchungRaum(id);
    }

    @Path("/geraet")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Bucht ein Gerät",
        description = "description"
    )
    public BuchungGeraet createBuchungGeraet(BuchungGeraet buchungGeraet) {
        return buchungService.createBuchungGeraet(buchungGeraet);
    }
    
    @Path("/geraet")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        summary = "Gibt alle Buchungen zurück",
        description = "description"
    )
    public List<BuchungGeraet> getBuchungGeraet() {
        return buchungService.getBuchungGeraet();
    }

    @Path("/geraet/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        summary = " Löscht eine Buchung",
        description = "description"
    )
    public void deleteBuchungGeraet(@PathParam("id") Long id) {
        buchungService.deleteBuchungGeraet(id);
    }





}
