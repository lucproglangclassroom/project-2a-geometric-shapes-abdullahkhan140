package edu.luc.cs.laufer.cs371.shapes

object BoundingBox:

  def apply(s: Shape): Rectangle = s match
    case Rectangle(w, h) =>
      Rectangle(w, h)

    case Ellipse(hr, vr) =>
      Rectangle(hr * 2, vr * 2)

    case Location(_, _, inner) =>
      apply(inner) // just return the size of the inner shape

    case Group(shapes @ _*) =>
      if shapes.isEmpty then Rectangle(0, 0)
      else
        val boxes = shapes.map(apply)
        val widths = boxes.map(_.width)
        val heights = boxes.map(_.height)
        Rectangle(widths.max, heights.max)

    case Overlay(top, bottom) =>
      val box1 = apply(top)
      val box2 = apply(bottom)
      Rectangle(
        Math.max(box1.width, box2.width),
        Math.max(box1.height, box2.height)
      )
