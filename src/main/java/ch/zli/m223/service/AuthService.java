package ch.zli.m223.service;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import ch.zli.m223.model.Credentials;
import ch.zli.m223.model.Person;
import io.smallrye.jwt.build.Jwt;

@ApplicationScoped
public class AuthService {
    
    @Inject
    UserService userService;

    public Response authenticate(Credentials credential) {
        Optional<Person> user = userService.findByMail(credential.getEmail());
        
        try{
            if(user.isPresent() && user.get().getPassword().equals(credential.getPassword()) && user.get().getRole().getId() == 1 ){
                String token = Jwt
                    .issuer("https://example.com/issuer")
                    .upn(credential.getEmail())
                    .groups(new HashSet<>(Arrays.asList( "Administrator")))
                    .expiresIn(Duration.ofHours(24))
                    .sign();
                return Response
                    .ok(user.get())
                    .cookie(new NewCookie("coworkingspace", token))
                    .header("Authorization", "Bearer " + token)
                    .build();
            }
            else if(user.isPresent() && user.get().getPassword().equals(credential.getPassword()) && user.get().getRole().getId() == 2 ){
                String token = Jwt
                    .issuer("https://example.com/issuer")
                    .upn(credential.getEmail())
                    .groups(new HashSet<>(Arrays.asList("Mitglied")))
                    .expiresIn(Duration.ofHours(24))
                    .sign();
                return Response
                    .ok(user.get())
                    .cookie(new NewCookie("coworkingspace", token))
                    .header("Authorization", "Bearer " + token)
                    .build();
            }
            else{
                return Response.status(Response.Status.UNAUTHORIZED).build();
            }
        }catch (Exception e) {
            System.err.println("Couldn't valitade Password");
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }


}
