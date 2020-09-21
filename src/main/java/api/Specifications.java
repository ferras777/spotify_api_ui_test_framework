package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Specifications {

    RequestSpecification requestSpecificationLookUp = new RequestSpecBuilder()
            .setBaseUri("https://dictionary.yandex.net/api/v1/dicservice.json/lookup")
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.ANY)
            .log(LogDetail.ALL)
            .build();
}
