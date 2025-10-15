package edu.luc.cs.laufer.cs371.shapes

import Shape.*

object scale:
  def apply(s: Shape, factor: Double): Shape = s match
    case Rectangle(width, height) =>
      Rectangle((width * factor).toInt, (height * factor).toInt)
      
    case Ellipse(width, height) =>
      // width and height are radii
      Ellipse((width * factor).toInt, (height * factor).toInt)
      
    case Location(x, y, shape) =>
      Location((x * factor).toInt, (y * factor).toInt, apply(shape, factor))
      
    case Group(shapes*) =>
      Group(shapes.map(s => apply(s, factor))*)

end scale