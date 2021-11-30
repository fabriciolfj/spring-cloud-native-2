package com.github.fabriciolfj.bddintegrationtransaction.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TransacaoFeatureSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransacaoFeatureSteps.class);
    private final String TRANSACAO_URL = "http://localhost:8080/api/v1/transactions";
    private static HttpHeaders headers;
    private static Response response;

    @Given("uma transacao {string}")
    public void uma_transacao(final String body) throws IOException {
        RestAssured.baseURI = TRANSACAO_URL;

        final RequestSpecification request = RestAssured.given();
        byte[] file = Files.readAllBytes(Paths.get(body));

        response = request.contentType(ContentType.JSON).headers(buildHeaders())
                .body(file)
                .given()
                .post(TRANSACAO_URL);

        LOGGER.info("Response: {}", response.toString());
    }

    @When("coletar consultar os dados")
    public void coletar_consultar_os_dados() {
        response = RestAssured
                .given()
                .headers(buildHeaders())
                .get(TRANSACAO_URL  + "/"  + "889-9989-87454-89");
    }


    @Then("teremos uma transação com id unico")
    public void teremos_uma_transação_com_id_unico() {
        final JsonPath jsonPath = response.jsonPath();
        final String uuid = jsonPath.getString("uuid");
        Assert.assertNotNull(uuid);
    }

    private HttpHeaders buildHeaders() {
        headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }

}
