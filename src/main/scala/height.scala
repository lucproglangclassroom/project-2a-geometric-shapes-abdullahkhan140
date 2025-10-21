package edu.luc.cs.laufer.cs371.shapes

object height:
  def apply(s: Shape): Int = s match
    case Rectangle(_, _) => 1
    case Ellipse(_, _) => 1
    case Location(_, _, inner) =>
      1 + apply(inner)
    case Group(shapes @ _*) =>
      if shapes.isEmpty then 1
      else 1 + shapes.map(apply).max
    case Overlay(top, bottom) =>
      1 + math.max(apply(top), apply(bottom))
