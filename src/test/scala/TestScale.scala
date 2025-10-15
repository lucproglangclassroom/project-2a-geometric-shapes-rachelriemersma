package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import TestFixtures.*
import Shape.*

class TestScale extends AnyFunSuite:

  test("scale rectangle by 2"):
    val scaled = scale(Rectangle(10, 20), 2.0)
    assert(scaled == Rectangle(20, 40))
    
  test("scale ellipse by 0.5"):
    val scaled = scale(Ellipse(100, 60), 0.5)
    assert(scaled == Ellipse(50, 30))
    
  test("scale location by 2"):
    val scaled = scale(Location(10, 20, Rectangle(5, 10)), 2.0)
    assert(scaled == Location(20, 40, Rectangle(10, 20)))
    
  test("scale simple group by 2"):
    val scaled = scale(simpleGroup, 2.0)
    val Location(_, _, Rectangle(w, h)) = boundingBox(scaled)
    assert(w == 700)
    assert(h == 560)
    
  test("scale by 1 returns equivalent shape"):
    val scaled = scale(complexGroup, 1.0)
    assert(size(scaled) == size(complexGroup))
    
  test("scale empty group"):
    val scaled = scale(Group(), 2.0)
    assert(scaled == Group())

end TestScale