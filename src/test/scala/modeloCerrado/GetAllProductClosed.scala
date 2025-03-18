package modeloCerrado
import io.gatling.core.Predef._
import io.gatling.http.Predef._
class GetAllProductClosed extends Simulation{

  val httpConfig = http.baseUrl("https://fakestoreapi.com")
    .acceptHeader("application/json")
  val scenario1 = scenario("Test consulta de todos los Productos modelo cerrado")
    .exec(
      http("Get All Product")
        .get("/products")
        .check(status.is(200))
    )
  setUp(
    scenario1.inject(
      rampConcurrentUsers(10).to(40)during(30),
      constantConcurrentUsers(20).during(20)
      )
  ).protocols(httpConfig)
}
