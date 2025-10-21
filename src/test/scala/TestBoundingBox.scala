package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import TestFixtures.*

class TestBoundingBox extends AnyFunSuite:

  def testBoundingBox(description: String, s: Shape, width: Int, height: Int): Unit =
    test(description):
      val Rectangle(w, h) = BoundingBox(s)
      assert(w == width)
      assert(h == height)

  testBoundingBox("simple rectangle", simpleRectangle, 10, 20)
  testBoundingBox("simple ellipse", simpleEllipse, 100, 60)
