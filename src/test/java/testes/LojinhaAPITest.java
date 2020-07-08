package testes;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Test;
import sun.nio.cs.ext.MacArabic;

public class LojinhaAPITest {
    @Test
    public void testBuscarDadosDeUmProdutoEspecifico(){
        RestAssured.baseURI = "http://165.227.93.41";
        RestAssured.basePath = "lojinha";

        String token = RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .body("{\n" +
                            " \"usuariologin\": \"roger.menegatte\",\n" +
                            " \"usuariosenha\": \"123456\"\n" +
                            "}")
                .when()
                    .post("login")
                .then()
                    .extract()
                        .path("data.token");

        RestAssured
                .given()
                    .header("token", token)
                .when()
                    .get("produto/6846")
                .then()
                    .assertThat()
                        .statusCode(200)
                        .body("data.produtonome", Matchers.equalTo("PS4"))
                        .body("data.componentes[0].componentenome", Matchers.equalTo("Controle"))
                        .body("message", Matchers.equalTo("Detalhando dados do produto"));
    }

    @Test
    public void testBuscarDadosDeUmComponenteDeProduto() {
        RestAssured.baseURI = "http://165.227.93.41";
        RestAssured.basePath = "lojinha";

        String token = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        " \"usuariologin\": \"roger.menegatte\",\n" +
                        " \"usuariosenha\": \"123456\"\n" +
                        "}")
                .when()
                .post("login")
                .then()
                .extract()
                .path("data.token");

        RestAssured
                .given()
                    .header("token", token)
                .when()
                    .get("produto/6846/componente/1733")
                .then()
                    .assertThat()
                        .statusCode(200)
                        .body("data.componentenome", Matchers.equalTo("Controle"))
                        .body("data.componentequantidade", Matchers.equalTo("2"))
                        .body("message", Matchers.equalTo("Detalhando dados do componente de produto"));

    }
}
