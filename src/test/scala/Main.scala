package edu.luc.cs.laufer.cs371.shapes

@main def Main(): Unit =
  val simpleLocation = Location(70, 30, Rectangle(80, 120))
  println(BoundingBox(simpleLocation))
