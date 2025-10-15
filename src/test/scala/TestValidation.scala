package edu.luc.cs.laufer.cs371.shapes

import org.scalatest.funsuite.AnyFunSuite
import Shape.*

class TestValidation extends AnyFunSuite:
  
  test("Rectangle with negative width throws exception"):
    assertThrows[IllegalArgumentException]:
      Shape.rectangle(-10, 20)
  
  test("Rectangle with negative height throws exception"):
    assertThrows[IllegalArgumentException]:
      Shape.rectangle(10, -20)
      
  test("Ellipse with negative width throws exception"):
    assertThrows[IllegalArgumentException]:
      Shape.ellipse(-10, 20)
      
  test("Ellipse with negative height throws exception"):
    assertThrows[IllegalArgumentException]:
      Shape.ellipse(10, -20)
      
  test("Valid shapes do not throw exceptions"):
    assert(Shape.rectangle(10, 20) != null)
    assert(Shape.ellipse(10, 20) != null)

end TestValidation