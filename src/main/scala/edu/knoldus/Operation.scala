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

  val blogCount = 5

  def blogCountIncrease(map: Map[String, Int], count: Int = blogCount): String = {

    val tempMap = collection.mutable.Map() ++ map
    val keyArray = tempMap.keySet.toArray
    val key = keyArray(Random.nextInt(keyArray.length))
    if (count > 0) {
      tempMap.update(key, tempMap(key) + 1)
      val callMap = tempMap.toMap[String, Int]
      blogCountIncrease(callMap, count - 1)
    }
    else {
      val callMap = tempMap.toMap[String, Int]
      favoriteBlog(callMap)
    }

  }

  def diceRollandTrainer(person: Person): String = {

    val trainerCount = 51

    def diceResult(name: String, count: Int = 3): String = {

      if (count > 0) {
        val six = 6
        val dice = Random.nextInt(six) + 1
        dice match {
          case 1 | 6 => diceResult(name, count - 1)
          case _ => s"$name you are loser "
        }
      }
      else {
        s"$name you are winner"
      }

    }

    person match {

      case Gamer(name) => diceResult(name)
      case Trainer(_) => Random.nextInt(trainerCount).toString
      case Blogger(_) => val map = Map("scala" -> 2, "java" -> 6, "kafka" -> 4)
        blogCountIncrease(map)
      case _ => "invalid person..."
    }

  }
}
