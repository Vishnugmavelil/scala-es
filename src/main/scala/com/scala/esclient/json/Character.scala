package com.scala.esclient.json

import com.sksamuel.elastic4s.Indexable

case class Character(name: String, location: String)

// turn instances of characters into json
object Implicit {

  implicit object CharacterIndexable extends Indexable[Character] {
    override def json(t: Character): String = s""" { "name" : "${t.name}", "location" : "${t.location}" } """
  }

}