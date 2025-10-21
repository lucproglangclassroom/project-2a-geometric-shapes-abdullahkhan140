package edu.luc.cs.laufer.cs371.shapes

object TestFixtures:
  val simpleRectangle = Rectangle(10, 20)
  val simpleEllipse   = Ellipse(50, 30)

  val simpleLocation  = Location(70, 30, simpleEllipse)

  val basicGroup = Group(
    simpleRectangle,
    simpleEllipse
  )

  val simpleGroup = Group(
    simpleLocation,
    basicGroup
  )

  val complexGroup = Group(
    simpleLocation,
    simpleGroup,
    basicGroup
  )
