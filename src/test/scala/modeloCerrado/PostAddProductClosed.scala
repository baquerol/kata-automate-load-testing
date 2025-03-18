package modeloCerrado
import io.gatling.core.Predef._
import io.gatling.http.Predef._
class PostAddProductClosed extends Simulation{

  val httpConfig = http.baseUrl("https://fakestoreapi.com")
    .acceptHeader("application/json")
    .contentTypeHeader("application/json")
  val archivo = csv("data/addProduct.csv").circular
  val scenario1 = scenario("Test Agregar Productos modelo cerrado")
    .feed(archivo)
    .exec(
      http("Post Add Product")
        .post("/products")
        .body(ElFileBody("data/postAddProduct.json"))
        .check(status.is(200))
        .check(bodyString.saveAs("response"))
    )
  setUp(
    scenario1.inject(
      rampConcurrentUsers(10).to(40) during (30),
      constantConcurrentUsers(20).during(20)
    )
  ).protocols(httpConfig)
}