package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import TestFixtures.*
import Shape.*

class TestSize extends AnyFunSuite:

  test("simple ellipse has size 1"):
    assert(size(simpleEllipse) == 1)
    
  test("simple rectangle has size 1"):
    assert(size(simpleRectangle) == 1)
    
  test("simple location has size 1"):
    assert(size(simpleLocation) == 1)
    
  test("basic group has size 2"):
    assert(size(basicGroup) == 2)
    
  test("simple group has size 2"):
    assert(size(simpleGroup) == 2)
    
  test("complex group has size 5"):
    assert(size(complexGroup) == 5)
    
  test("empty group has size 0"):
    assert(size(Group()) == 0)

end TestSize