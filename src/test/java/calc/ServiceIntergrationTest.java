/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

import org.junit.Test;
import static org.junit.Assert.*;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.parsing.Parser;
import static org.hamcrest.Matchers.*;
import org.junit.BeforeClass;



/**
 *
 * @author philliphbrink
 */
public class ServiceIntergrationTest {
    
    public ServiceIntergrationTest() {
    }
    
    @BeforeClass
    public static void setUpBeforeAll() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/Test1";
        RestAssured.defaultParser = Parser.JSON;
    }
    
    @Test
    public void serverIsRunning() {
        given().
        when().
        get().
        then().
        statusCode(200);
        
    }
    
    @Test
    public void addOperation() {
        given().pathParam("n1", 2).pathParam("n2", 2).
        when().get("/api/calculator/add/{n1}/{n2}").
        then().statusCode(200).
        body("result", equalTo(4), "operation", equalTo("2 + 2"));
    }
    
    @Test
    public void subOperation() {
        given().pathParam("n1", 6).pathParam("n2", 3).
        when().get("/api/calculator/sub/{n1}/{n2}").
        then().statusCode(200).
        body("result", equalTo(3), "operation", equalTo("6 - 3"));
    }
    
    @Test
    public void mulOperation() {
        given().pathParam("n1", 2).pathParam("n2", 5).
        when().get("/api/calculator/mul/{n1}/{n2}").
        then().statusCode(200).
        body("result", equalTo(10), "operation", equalTo("2 * 5"));
    }
    
    @Test
    public void divOperation() {
        given().pathParam("n1", 10).pathParam("n2", 2).
        when().get("/api/calculator/div/{n1}/{n2}").
        then().statusCode(200).
        body("result", equalTo(5), "operation", equalTo("10 / 2"));
    }
    
    @Test
    public void nonExistingOperation() {
        given().pathParam("n1", 10).pathParam("n2", 2).
        when().get("/api/calculator/abc/{n1}/{n2}").
        then().statusCode(404).
        body("code", equalTo(404));
    }
    
    @Test
    public void illegalOperation() {
        given().pathParam("n1", 10).pathParam("n2", 2.12).
        when().get("/api/calculator/add/{n1}/{n2}").
        then().statusCode(400).
        body("code", equalTo(400));
    }
    
    @Test
    public void divByZeroOperation() {
        given().pathParam("n1", 10).pathParam("n2", 0).
        when().get("/api/calculator/div/{n1}/{n2}").
        then().statusCode(500).
        body("code", equalTo(500));
    }
    
    
}
