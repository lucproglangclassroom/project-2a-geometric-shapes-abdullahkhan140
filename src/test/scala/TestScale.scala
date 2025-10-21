package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import TestFixtures.*

class TestScale extends AnyFunSuite:

  def testScale(description: String, s: Shape, factor: Double, expected: Shape): Unit =
    test(description):
      assert(scale(s, factor).equals(expected))

  testScale("scale rectangle", Rectangle(10, 20), 2.0, Rectangle(20, 40))
  testScale("scale ellipse", Ellipse(5, 10), 2.0, Ellipse(10, 20))
  testScale("scale location", Location(10, 20, Rectangle(10, 20)), 2.0, Location(20, 40, Rectangle(20, 40)))
  testScale("scale group", Group(Rectangle(5, 5), Ellipse(2, 3)), 2.0, Group(Rectangle(10, 10), Ellipse(4, 6)))
  testScale("scale overlay", Overlay(Rectangle(5, 5), Ellipse(2, 3)), 2.0, Overlay(Rectangle(10, 10), Ellipse(4, 6)))
