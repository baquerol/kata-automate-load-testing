package modeloCerrado
import io.gatling.core.Predef._
import io.gatling.http.Predef._
class DeleteProductClosed extends Simulation{

  val httpConfig = http.baseUrl("https://fakestoreapi.com")
    .acceptHeader("application/json")
    .contentTypeHeader("application/json")
  val archivo = csv("data/deleteProduct.csv").circular
  val scenario1 = scenario("Test actualizar Productos modelo cerrado")
    .feed(archivo)
    .exec(
      http("Put Update Product")
        .delete("/products/${id}")
        .check(status.is(200))
    )
  setUp(
    scenario1.inject(
      rampConcurrentUsers(10).to(40) during (30),
      constantConcurrentUsers(20).during(20)
    )
  ).protocols(httpConfig)
}