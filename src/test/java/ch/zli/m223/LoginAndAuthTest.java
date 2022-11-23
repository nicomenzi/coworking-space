package ch.zli.m223;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import ch.zli.m223.model.Person;
import ch.zli.m223.model.Role;

@QuarkusTest
public class LoginAndAuthTest {


    //@Test
    //public void testRegister() {
    //    var Role = new Role();
    //    Role.setName("Administrator");
    //    
//
    //    var Person = new Person();
    //    Person.setName("testuser");
    //    Person.setNachname("null");
    //    Person.setPassword("testpassword");
    //    Person.setEmail("nico@menzi.ch");
    //    Person.setRole(Role);
//
    //    System.out.println(Person);
//
    //    var response = given()
    //        .contentType("application/json")
    //        .body(Person)
    //        .when().post("/register");
//
    //    given()
    //    .when().delete("/register/" + response.jsonPath().get("id"))
    //    .then()
    //      .statusCode(200);   
//
    //    
    //        
    //
    // 
    //}


    //@Test
    //public void loginEndpointPositive() {
    //  given().contentType(ContentType.JSON)
    //  .body("{ \"username\" : \"zuckermans\",\"password\" : \"admin1234\"}")
    //  .when().post("http://localhost:8080/auth")
    //  .then()
    //     .statusCode(200);
    //}

    @Test
    public void registerPositive() {
        given().contentType(ContentType.JSON)
          .body("{\"name\":\"test\",\"nachname\":\"test\",\"email\":\"test@test.test\",\"password\":\"test\",\"role\":{\"id\":1}}")
          .when().post("http://localhost:8080/register")
          .then()
             .statusCode(200);
    }

    @Test
    public void registerNegative() {
        given().contentType(ContentType.JSON)
          .body("{\"name\":\"test\",\"nachname\":\"test\",\"email\":\"test@test.test\",\"password\":\"test\"}")
          .when().post("http://localhost:8080/register")
          .then()
             .statusCode(500);
    }

    @Test
    public void loginPositive() {

        given().contentType(ContentType.JSON)
        .body("{\"name\":\"test\",\"nachname\":\"test\",\"email\":\"test@test.test\",\"password\":\"test\",\"role\":{\"id\":1}}")
          .when().post("http://localhost:8080/register")
          .then();

        given().contentType(ContentType.JSON)
          .body("{\"email\":\"test@test.ch\",\"password\":\"test\"}")
            .when().post("http://localhost:8080/auth")
            .then()
               .statusCode(401);
    }

    
}
