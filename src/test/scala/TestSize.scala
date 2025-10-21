package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import TestFixtures.*

class TestSize extends AnyFunSuite:

  def testSize(description: String, s: Shape, expected: Int): Unit =
    test(description):
      assert(size(s) == expected)

  testSize("simple rectangle", simpleRectangle, 1)
  testSize("simple ellipse", simpleEllipse, 1)
  testSize("simple location", simpleLocation, 1) // keep as 1, because Location does not add
  testSize("basic group", basicGroup, 2)         // Rectangle + Ellipse = 1 + 1
  testSize("simple group", simpleGroup, 3)       // simpleLocation(1) + basicGroup(2) = 3
  testSize("complex group", complexGroup, 6)     // simpleLocation(1) + simpleGroup(3) + basicGroup(2) = 6
