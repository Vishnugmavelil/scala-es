import com.sksamuel.elastic4s.http.JavaClient
import com.sksamuel.elastic4s.{ElasticClient, ElasticProperties, Indexable, RequestFailure, RequestSuccess, Response}
import com.scala.esclient.util.Constant
import com.sksamuel.elastic4s.ElasticApi.{RichFuture, createIndex, indexInto, keywordField, properties, search, simpleStringQuery, termQuery, textField, updateById}
import com.sksamuel.elastic4s.ElasticDsl.{CreateIndexHandler, IndexHandler, SearchHandler, UpdateHandler}
import com.sksamuel.elastic4s.requests.indexes.CreateIndexResponse
import com.sksamuel.elastic4s.requests.searches.SearchResponse
import com.scala.esclient.exception.CustomException
import com.sksamuel.elastic4s.ElasticApi.emptyMapping.source
import com.sksamuel.elastic4s.Index.All.index
import com.sun.xml.internal.ws.client.sei.ResponseBuilder.Body
//import org.apache.logging.log4j.scala.Logging
//import org.apache.logging.log4j.Level
import com.scala.esclient.json.Character
import com.scala.esclient.json.CharacterUpdate
import com.scala.esclient.json.Implicit.CharacterIndexable
import com.scala.esclient.json.ImplicitUpdate.CharacterIndexableUpdate

import com.scala.esclient.config.Config
import com.typesafe.scalalogging.Logger


object ESClient extends App {

  val URL = Config.ES_END
  val INDEX = Config.INDEX
  val connect = ElasticProperties(URL)
  val client = ElasticClient(JavaClient(connect))

  val logger = Logger("Root")

  def createIndices(indexName: String): Unit = {
    try {
      val exe = client.execute {
        createIndex(indexName)
      }
    } catch {
      case e: CustomException => {
        e.printStackTrace
      }
    }

  }

  /*
  def addValuesWithId(indexName: String, id: String, name: String, place: String): Unit = {
    try {
      val exe = client.execute {
        indexInto(indexName).id(id).fields(
          "name" -> name,
          "place" -> place
        )
      }.await
    } catch {
      case e: CustomException => {
        e.printStackTrace
      }
    }
  }
  */


  def addValuesWithBody(jsonBody: Character, id: String): Unit = {
    try {
      client.execute {
        indexInto(INDEX).id(id).doc(jsonBody)
      }.await
    } catch {
      case e: CustomException => {
        e.printStackTrace
      }
    }
  }

  def simpleSearch(indexName: String, value: String): Unit = {
    try {
      val response: Response[SearchResponse] = client.execute {
        search(indexName).query(simpleStringQuery(value))
      }.await
      return response
      logger.info("---- Search Results ----")
      response match {
     //   case failure: RequestFailure => logger.info("failure"+failure.error)
        case results: RequestSuccess[SearchResponse] => logger.info("success")
        case results: RequestSuccess[_] => logger.info(" values "+results.result)
      }
      response foreach (search => logger.info(s"There were ${search.totalHits} total hits"))
      val out = response.result.hits.hits.head.sourceAsString

    } catch {
      case n: NoSuchElementException => {
        n.printStackTrace
      }
      case e: CustomException => {
        e.printStackTrace
      }
    }

  }

  def simpleUpdateWithBody(indexName: String, id: String,json:CharacterUpdate): Unit = {
    try {
      val response = client.execute {
        updateById(indexName, id).doc(json)
      }.await
    } catch {
      case e: CustomException => {
        //e.printStackTrace
        println("exception")
      }
    }
  }

  //simpleSearch(Constant.INDEX_NAME,"ABQ")

  client.close()

}

