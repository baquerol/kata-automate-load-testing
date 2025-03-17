package modeloAbierto

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class GetAllProductsConstantUsersDuring extends Simulation{

  val httpConfig = http.baseUrl("https://fakestoreapi.com")
    .acceptHeader("application/json")


  val scenario1 = scenario("Test consulta de todos los Productos")
    .exec(
      http("Get All Product")
        .get("/products")
        .check(status.is(200))
    )


  setUp(
    scenario1.inject(constantUsersPerSec(20).during(5))
  ).protocols(httpConfig)


}