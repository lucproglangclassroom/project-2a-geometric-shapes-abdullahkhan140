package edu.luc.cs.laufer.cs371.shapes
import edu.luc.cs.laufer.cs371.shapes.*

object size:
  def apply(s: Shape): Int = s match
    case Rectangle(_, _) => 1
    case Ellipse(_, _) => 1
    case Location(_, _, inner) => apply(inner)
    case Group(shapes @ _*) => shapes.map(apply).sum
    case Overlay(top, bottom) => apply(top) + apply(bottom)
