package modeloAbierto

import io.gatling.core.scenario.Simulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._
class GetAllProductsRampUsers extends Simulation{

  val httpConfig = http.baseUrl("https://fakestoreapi.com")
    .acceptHeader("application/json")


  val scenario1 = scenario("Test consulta de todos los Productos")
    .exec(
      http("Get All Product")
        .get("/products")
        .check(status.is(200))
    )


  setUp(
    scenario1.inject(rampUsers(100).during(30))
  ).protocols(httpConfig)


}
