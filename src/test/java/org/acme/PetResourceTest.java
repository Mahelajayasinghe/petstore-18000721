package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.allOf;

@QuarkusTest
public class PetResourceTest {

	@Test
    public void testPetEndpoint() {
        given()
          .when().get("/v1/pets")
          .then()
             .statusCode(200);
//             .body(hasItem(
// 		            allOf(
//    		                hasEntry("pet_id", "1"),
//    		                hasEntry("pet_type", "Dog"),
//    		                hasEntry("pet_name", "Boola"),
//    		                hasEntry("pet_age", "3")
//    		            )
//    		      )
//    		 );
    }

    @Test
    public void testGetPetEndpoint() {
        given()
                .when().get("/v1/pets/2")
                .then()
                .statusCode(200);
             //.body("petId", is(2));
    }

//    @Test
//    public void testPostPetEndpoint() {
//        given()
//                .when().post("/v1/pets/")
//                .then()
//                .statusCode(200)
//                .body("petName", is("Panda"))
//                .body("petType", is("Dog"))
//                .body("petAge", is(10))
//        ;
//    }

}