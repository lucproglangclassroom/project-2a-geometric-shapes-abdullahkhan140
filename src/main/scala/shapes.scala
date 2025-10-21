package edu.luc.cs.laufer.cs371.shapes

sealed trait Shape
case class Rectangle(width: Int, height: Int) extends Shape
case class Ellipse(horizontalRadius: Int, verticalRadius: Int) extends Shape
case class Location(x: Int, y: Int, shape: Shape) extends Shape
case class Group(shapes: Shape*) extends Shape
case class Overlay(shape1: Shape, shape2: Shape) extends Shape
