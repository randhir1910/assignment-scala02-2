package edu.knoldus

import scala.util.Random

abstract class Person

case class Gamer(name: String) extends Person

case class Trainer(name: String) extends Person

case class Blogger(name: String) extends Person

class Operation {

  def favoriteBlog(blogList: Map[String, Int]): String = {

    blogList.maxBy(_._2).toString()

  }

  def blogCountIncrease(map: Map[String, Int], blogCount: Int = Constants.BLOGCOUNT): String = {

    if (blogCount > 0) {

      val keyArray = map.keySet.toArray
      val key = keyArray(Random.nextInt(keyArray.length))
      val value = map.getOrElse(key, 0)
      val tempMap = map + (key -> (value + 1))
      blogCountIncrease(tempMap, blogCount - 1)

    }

    else {

      favoriteBlog(map)

    }
  }

  def diceRollandTrainer(person: Person): String = {


    def diceResult(name: String, count: Int = 3): String = {

      if (count > 0) {

        val dice = Random.nextInt(Constants.SIX) + 1
        dice match {
          case Constants.ONE | Constants.SIX => diceResult(name, count - 1)
          case _ => s"$name you are loser "
        }
      }
      else {
        s"$name you are winner"
      }
    }

    person match {

      case Gamer(name) => diceResult(name)
      case Trainer(_) => Random.nextInt(Constants.FIFTYONE).toString
      case Blogger(_) => val map = Map("scala" -> 2, "java" -> 6, "kafka" -> 4)
        blogCountIncrease(map)
      case _ => "invalid person..."

    }
  }
}
