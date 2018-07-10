package com.msucil.scalaPractices.json

/**
  * Convert Json Object to Scala Object
  *
  * { ”firstName” : ”John”,
  * ”lastName” : ”Smith”,
  * ”address ”: {
  * ”streetAddress ”: ”21 2nd  Street”,
  * ”state ”: ”NY”,
  * ”postalCode ”:  10021
  * },
  * ”phoneNumbers ”: [
  * { ”type”: ”home”, ”number ”: ”212  555 -1234” },
  * { ”type”: ”fax”, ”number ”: ”646  555 -4567” }
  * ]
  * }
  *
  */

abstract class JSON

case class JArray(elems: List[JSON]) extends JSON

case class JObject(bindings: Map[String, JSON]) extends JSON

case class JNumber(num: Double) extends JSON

case class JString(str: String) extends JSON

case class JBoolean(bool: Boolean) extends JSON

case object JNull extends JSON

object JsonToObject {

  def main(args: Array[String]): Unit = {
    val json = JObject(Map(
      "firstName" -> JString("Sushil"),
      "lastName" -> JString("Ale"),
      "address" -> JObject(Map(
        "streetAddress" -> JString("Buddhanagar, Kathmandu"),
        "state" -> JString("Bagmati"),
        "postalCode" -> JNumber(2020)
      )),
      "phoneNumber" -> JArray(
        List(
          JObject(Map(
            "type" -> JString("home"),
            "number" -> JString("984602828")
          )),
          JObject(Map(
            "type" -> JString("work"),
            "number" -> JString("985609293")
          ))
        )
      )
    ))

    println(show(json))
  }

  def show(json: JSON): String = json match {
    case JArray(elems) => {
      ": [" + (elems map show mkString ",") + "]"
    }
    case JObject(bindings) => {
      val assocs = bindings map {
        case (key, value) => '\"' + key + '\"' + show(value)
      }
      "{" + (assocs mkString ",") + "}"
    }
    case JNumber(num) =>{
      ": " + num.toString
    }
    case JString(str) => {
      ": " + '\"' + str + '\"'
    }
    case JBoolean(bool) => {
      ": " + bool.toString
    }
    case JNull => {
      ": null"
    }
  }
}