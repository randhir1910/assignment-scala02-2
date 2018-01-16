package edu.knoldus

class Payment {

  def paymentBill(amount: Double, payMethod: String): Double = {

    payMethod.toLowerCase.trim match {
      case "paytm" | "freecharge" => amount + amount * 0.02
      case "net banking" => amount + 5
      case "card payment" => amount + 1.5
      case "cash" => amount
      case _ => amount
    }

  }
}
