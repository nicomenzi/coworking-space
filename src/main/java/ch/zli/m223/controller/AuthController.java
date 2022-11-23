package ch.zli.m223.controller;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import ch.zli.m223.model.Credentials;
import ch.zli.m223.service.AuthService;

@Path("/auth")
@Tag(name = "Authentication", description = "Handling of authentication")
public class AuthController {

    @Inject
    AuthService authService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Authenticates a user.", description = "Authenticates a user and returns a JWT token.")
    public Response create(@Valid Credentials credential) {
        return this.authService.authenticate(credential);
    }

    
}
