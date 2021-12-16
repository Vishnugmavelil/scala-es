package com.scala.esclient.json

import com.sksamuel.elastic4s.Indexable

case class CharacterUpdate(age:Int)

object ImplicitUpdate {

  implicit object CharacterIndexableUpdate extends Indexable[CharacterUpdate] {
    override def json(t: CharacterUpdate): String = s""" { "age" : "${t.age}" } """
  }

}
