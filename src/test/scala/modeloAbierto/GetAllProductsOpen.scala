package modeloAbierto
import io.gatling.core.Predef._
import io.gatling.http.Predef._
class GetAllProductsOpen extends Simulation{
  val httpConfig = http.baseUrl("https://fakestoreapi.com")
    .acceptHeader("application/json")
  val scenario1 = scenario("Test consulta de todos los Productos modelo abierto")
    .exec(
      http("Get All Product")
        .get("/products")
        .check(status.is(200))
    )
  setUp(
    scenario1.inject(
      rampUsersPerSec(5).to(35).during(20),
      constantUsersPerSec(20).during(10).randomized,
      atOnceUsers(100)
    )
  ).protocols(httpConfig)


}
