package com.msucil.practice.scala.fpd.circuit

trait Simulation {
  type Action = () => Unit

  case class Event(time: Int, action: Action) {
    private type Agenda = List[Event]
  }

  private var curTime = 0

  private var agenda: List[Event] = List()

  //returns current simulated time
  def currentTime: Int = curTime

  private def insert(ag: List[Event], item: Event): List[Event] = {
    ag match {
      case first :: rest if first.time <= item.time => first :: insert(rest, item)
      case _  => item :: ag
    }
  }

  //register an action to perform after a certain dely relative to currentTime
  def afterDelay(delay: Int)(block: => Unit): Unit = {
    val item = Event(currentTime + delay, () => block)
    agenda = insert(agenda, item)
  }

  //performs the simulation until no actions waiting
  def run(): Unit = {
    afterDelay(0) {
      println("*** Simulation started, time = " + currentTime + " ***")
    }
    loop()
  }

  private def loop(): Unit = {
    agenda match {
      case first :: rest => {
        agenda = rest
        curTime = first.time
        first.action()
        loop()
      }
      case _ => {}
    }
  }
}
