
import org.scalatest._

class ESClientTest extends FlatSpec with Matchers{

 // val elasticHost = sys.env.getOrElse("ES_HOST", "127.0.0.1")
 // val elasticPort = sys.env.getOrElse("ES_PORT","39227")
 // val client = ElasticClient(JavaClient(ElasticProperties(s"http://$elasticHost:$elasticPort")))


  "ESClient" should "give name jesse" in {
  //  val output:Response[SearchResponse] = client.execute {
  //    search("scala_emp101").query(simpleStringQuery("jesse"))
  //  }.await
    val search = ESClient.simpleSearch("scala_emp101","ABQ")
    search should be ("")
 }

}

