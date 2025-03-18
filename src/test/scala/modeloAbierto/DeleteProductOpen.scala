package modeloAbierto
import io.gatling.core.Predef._
import io.gatling.http.Predef._
class DeleteProductOpen extends Simulation {
  val httpConfig = http.baseUrl("https://fakestoreapi.com")
    .acceptHeader("application/json")
    .contentTypeHeader("application/json")
  val archivo = csv("data/deleteProduct.csv").circular

  val scenario1 = scenario("Test actualizar Productos modelo abierto")
    .feed(archivo)
    .exec(
      http("Put Update Product")
        .delete("/products/${id}")
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
