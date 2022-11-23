package ch;

import org.junit.jupiter.api.Test;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

import javax.ws.rs.DELETE;

import org.junit.jupiter.api.Test;

import ch.zli.m223.model.Person;
import ch.zli.m223.model.Role;

@QuarkusTest
public class AdminResourceTest {
    
    @Test
    @TestSecurity(user = "testuser", roles = {"Administrator"})
    public void testgetMember() {
     given()
       .when().get("/admin/member")
       .then()
          .statusCode(200);
          
    }
    
    @Test
    @TestSecurity(user = "testuser", roles = {"Mitglied"})
    public void testgetMemberNegative() {
     given()
       .when().get("/admin/member")
       .then()
          .statusCode(403);
          
    }
    @Test
    @TestSecurity(user = "testuser", roles = {"Administrator"})
    public void testupdateMember() {
     given().contentType(ContentType.JSON)
     .body("{\"name\":\"test\",\"nachname\":\"test\",\"email\":\"test@test.test\",\"password\":\"test\",\"role\":{\"id\":1}}")
        .when().put("/admin/member/1")
        .then()
            .statusCode(200);
    }
    @Test
    @TestSecurity(user = "testuser", roles = {"Mitglied"})
    public void testupdateBuchungNegative() {
     given().contentType(ContentType.JSON)
     .body("{ \"status\":1, \"dateStart\":\"2022-03-10T12:15:50\", \"dateEnd\":\"2022-03-10T12:15:50\", \"person\":{\"id\":1, \"role\":{\"id\":1}}, \"raum\":{\"id\":1}")
        .when().put("/admin/buchungGeraet/1")
        .then()
            .statusCode(403);
    }
    @Test
    @TestSecurity(user = "testuser", roles = {"Administrator"})
    public void testdeleteBuchungGeraet() {
     given()
       .when().delete("/admin/buchungGeraet/1")
       .then()
          .statusCode(204);
          
    }

    @Test
    @TestSecurity(user = "testuser", roles = {"Administrator"})
    public void testdeleteBuchungRaumNegative() {
     given()
       .when().delete("/admin/buchungRaum/99")
       .then()
          .statusCode(500);
          
    }
}
    
   
