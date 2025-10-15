package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import TestFixtures.*
import Shape.*

class TestHeight extends AnyFunSuite:

  test("simple ellipse has height 1"):
    assert(height(simpleEllipse) == 1)
    
  test("simple rectangle has height 1"):
    assert(height(simpleRectangle) == 1)
    
  test("simple location has height 2"):
    assert(height(simpleLocation) == 2)
    
  test("basic group has height 2"):
    assert(height(basicGroup) == 2)
    
  test("simple group has height 3"):
    assert(height(simpleGroup) == 3)
    
  test("complex group has height 6"):
    assert(height(complexGroup) == 6)
    
  test("empty group has height 1"):
    assert(height(Group()) == 1)

end TestHeight