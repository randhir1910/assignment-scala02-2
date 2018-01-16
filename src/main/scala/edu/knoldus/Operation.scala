package edu.knoldus

import scala.util.Random

abstract class Person

case class Gamer(name: String) extends Person

case class Trainer(name: String) extends Person

class Operation {

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
      case _ => "invalid person..."
    }
  }
}
