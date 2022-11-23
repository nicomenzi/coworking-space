package ch.zli.m223;


import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

@QuarkusTest
public class BuchungResourceTest {

    @Test
    @TestSecurity(user = "testuser", roles = {"Administrator"})
    public void testgetBuchungRaum() {
     given()
       .when().get("/buchung")
       .then()
          .statusCode(200);
          
    }

    

    @Test
    @TestSecurity(user = "testuser", roles = {""})
    public void testcreateBuchungNegative() {
     given().contentType(ContentType.JSON)
     .body("{ \"status\":\"test\", \"dateStart\":\"2022-03-10T12:15:50\", \"dateEnd\":\"2022-03-10T12:15:50\", \"person\":{\"id\":1}, \"raum\":{\"id\":1}")
     .when().post("/buchung")
       .then()
          .statusCode(403);
    }

    @Test
    @TestSecurity(user = "testuser", roles = {""})
    public void testgetBuchungRaumNegative() {
     given()
       .when().get("/buchung")
       .then()
          .statusCode(403);
          
    }

    @Test
    @TestSecurity(user = "testuser", roles = {"Administrator"})
    public void testdeleteBuchung() {
     given()
       .when().delete("/buchung/1")
       .then()
          .statusCode(204);
          
    }
    @Test
    @TestSecurity(user = "testuser", roles = {"Administrator"})
    public void testdeleteBuchungGeraet() {
      //try to delete a non existing buchung
     given()
       .when().delete("/buchung/geraet/1")
       .then()
          .statusCode(500);
          
    }

    @Test
    @TestSecurity(user = "testuser", roles = {""})
    public void testdeleteBuchungAuthNegative() {
     given()
       .when().delete("/buchung/geraet/1")
       .then()
          .statusCode(403);
          
    }

    @Test
    @TestSecurity(user = "testuser", roles = {"Administrator"})
    public void testgetBuchungGeraet() {
     given()
       .when().get("/buchung/geraet")
       .then()
          .statusCode(200);
          
    }


   

   



 

    
}
