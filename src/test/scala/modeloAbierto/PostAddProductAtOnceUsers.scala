package modeloAbierto
import io.gatling.core.Predef._
import io.gatling.http.Predef._
class PostAddProductAtOnceUsers extends Simulation{

  val httpConfig = http.baseUrl("https://fakestoreapi.com")
    .acceptHeader("application/json")
    .contentTypeHeader("application/json")

  val archivo= csv("data/producto.csv").circular


  val scenario1 = scenario("Test Agregar Productos")
    .feed(archivo)
    .exec(
      http("Post Add Product")
        .post("/products")
        .body(ElFileBody("data/postAddProduct.json"))
        .check(status.is(200))
        .check(bodyString.saveAs("response"))
    )


  setUp(
    scenario1.inject(atOnceUsers(10))
  ).protocols(httpConfig)


}

