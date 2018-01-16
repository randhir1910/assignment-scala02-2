package edu.knoldus

import org.apache.log4j.Logger

object Application extends App {

  val log = Logger.getLogger(this.getClass)

   val payment = new Payment
   val amount = 100

   log.info(payment.paymentBill(amount, "paytm") + "\n")
   log.info(payment.paymentBill(amount, "freecharge") + "\n")
   log.info(payment.paymentBill(amount, "net banking") + "\n")
   log.info(payment.paymentBill(amount, "card payment") + "\n")
   log.info(payment.paymentBill(amount, "cash") + "\n")

  val operation = new Operation

  val gamer = Gamer("randhir")
  val trainer = Trainer("sangeetika")
  log.info(operation.diceRollandTrainer(gamer) + "\n")
  log.info(operation.diceRollandTrainer(trainer) + "\n")

}
