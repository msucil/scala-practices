package com.msucil.practice.scala.fpd.circuit

object CircuitSimulation extends Circuit  with Parameters {

  def main(args: Array[String]): Unit = {
    val  in1, in2, sum, carry = new Wire

    halfAdder(in2, in2, sum, carry)

    probe("sum", sum)
    probe("carry", carry)

    in1 setSignal true

    run()
  }
}
