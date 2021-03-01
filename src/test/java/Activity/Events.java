package Activity;

;
import Pojo.CodesOfConductPOJO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Events {

    @BeforeAll
    public static void setUp(){

        baseURI="https://api.github.com";

    }

    @Test
    public void PositiveTest(){


        Response response= given().header("Accept","application/vnd.github.scarlet-witch-preview+json" )
                           .when().get("/codes_of_conduct");
        Assertions.assertEquals(response.statusCode(),200);
        assertEquals(response.contentType(), "application/json; charset=utf-8");
        //response.prettyPrint();

        String key=response.path("key[0]");
        String name=response.path("name[0]");
        Objects html_url=response.path("html_url[0]");
        String url=response.path("url[0]");

        assertEquals(key, "contributor_covenant");
        assertEquals(name, "Contributor Covenant");
        assertEquals(html_url, null);
        assertEquals(url, "https://api.github.com/codes_of_conduct/contributor_covenant");


        /*
        List<CodesOfConductPOJO>list=response.body().as(List.class)   ;
        System.out.println(list);
         */

    }

    @Test
    public void NegativeTest(){

        given().accept(ContentType.JSON).when().get("/codes_of_conduct")
                .then().assertThat().statusCode(415).and().assertThat().contentType("application/json; charset=utf-8");

    }

    @Test
    public void NegativeTest2(){

        given().header("Accept","application/vnd.github.scarlet-witch-preview+json" )
                .when().get("/codes_of_conduc")
                .then().assertThat().statusCode(404).and().assertThat().contentType("application/json; charset=utf-8");
    }


}
