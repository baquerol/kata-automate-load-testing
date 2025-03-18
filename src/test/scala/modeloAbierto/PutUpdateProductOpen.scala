package modeloAbierto
import io.gatling.core.Predef._
import io.gatling.http.Predef._
class PutUpdateProductOpen extends Simulation {

  val httpConfig = http.baseUrl("https://fakestoreapi.com")
    .acceptHeader("application/json")
    .contentTypeHeader("application/json")

  val archivo = csv("data/updateProduct.csv").circular
  val scenario1 = scenario("Test actualizar Productos modelo abierto")
    .feed(archivo)
    .exec(
      http("Put Update Product")
        .put("/products/${id}")
        .body(ElFileBody("data/putUpdateProduct.json"))
        .check(status.is(200))
        .check(bodyString.saveAs("response"))
    )
  setUp(
    scenario1.inject(
      rampUsersPerSec(5).to(35).during(20),
      constantUsersPerSec(20).during(10).randomized,
      atOnceUsers(100)
    )
  ).protocols(httpConfig)
}
