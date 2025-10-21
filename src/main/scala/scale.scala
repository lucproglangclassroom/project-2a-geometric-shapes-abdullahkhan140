package edu.luc.cs.laufer.cs371.shapes

object scale:
  def apply(s: Shape, factor: Double): Shape = s match
    case Rectangle(w, h) =>
      Rectangle((w * factor).toInt, (h * factor).toInt)
    case Ellipse(rx, ry) =>
      Ellipse((rx * factor).toInt, (ry * factor).toInt)
    case Location(x, y, inner) =>
      Location((x * factor).toInt, (y * factor).toInt, apply(inner, factor))
    case Group(shapes @ _*) =>
      Group(shapes.map(s => apply(s, factor))*)
    case Overlay(top, bottom) =>
      Overlay(apply(top, factor), apply(bottom, factor))
