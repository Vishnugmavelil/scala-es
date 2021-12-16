package com.scala.esclient.config
import org.yaml.snakeyaml.Yaml
import java.io.{File, FileInputStream}

object Config {
    val ios = new FileInputStream(new File("config.yaml"))
    val yaml = new Yaml()
    val obj = yaml.load(ios).asInstanceOf[java.util.Map[String, Any]]
    val INDEX = obj.get("index").toString
    val ES_END = obj.get("esend").toString

}





