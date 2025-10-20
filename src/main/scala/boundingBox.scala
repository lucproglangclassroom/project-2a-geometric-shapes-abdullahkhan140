package edu.luc.cs.laufer.cs371.shapes
import Shape.*

object boundingBox:
  def apply(s: Shape): Location = s match
    // if it's just a rectangle, its bounding box is itself
    case Rectangle(w, h) =>
      Location(0, 0, Rectangle(w, h))
    // for an ellipse, the box is a rectangle around it (double the radius)
    case Ellipse(rx, ry) =>
      Location(0, 0, Rectangle(2 * rx, 2 * ry))
    // for a location, move the inner box by the given x and y
    case Location(x, y, inner) =>
      val box = apply(inner)
      Location(x + box.x, y + box.y, box.shape.asInstanceOf[Rectangle])
    // for a group of shapes, find the smallest box that covers them all
    case Group(shapes) =>
      val boxes = shapes.map(apply) // get boxes for each shape
      val xs = boxes.map(_.x)
      val ys = boxes.map(_.y)
      val xMax = boxes.map(b => b.x + b.shape.asInstanceOf[Rectangle].width)
      val yMax = boxes.map(b => b.y + b.shape.asInstanceOf[Rectangle].height)
      // the total box uses min
