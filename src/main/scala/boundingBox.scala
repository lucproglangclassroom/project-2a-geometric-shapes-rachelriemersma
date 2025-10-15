package edu.luc.cs.laufer.cs371.shapes

import Shape.*
import com.typesafe.scalalogging.LazyLogging

object boundingBox extends LazyLogging:
  def apply(s: Shape): Location = 
    logger.debug(s"Computing bounding box for: $s")
    
    val result: Location = s match
      case Rectangle(width, height) =>
        Location(0, 0, Rectangle(width, height))
        
      case Ellipse(width, height) =>
        // width and height are RADII, so bounding box is 2x in each dimension
        Location(-width, -height, Rectangle(2 * width, 2 * height))
        
      case Location(x, y, shape) =>
        val Location(childX, childY, rect) = apply(shape)
        Location(x + childX, y + childY, rect)
        
      case Group(shapes*) =>
        if shapes.isEmpty then
          Location(0, 0, Rectangle(0, 0))
        else
          val boxes = shapes.map(apply)
          
          val lefts = boxes.map { case Location(x, _, Rectangle(_, _)) => x }
          val rights = boxes.map { case Location(x, _, Rectangle(w, _)) => x + w }
          val tops = boxes.map { case Location(_, y, Rectangle(_, _)) => y }
          val bottoms = boxes.map { case Location(_, y, Rectangle(_, h)) => y + h }
          
          val minX = lefts.min
          val maxX = rights.max
          val minY = tops.min
          val maxY = bottoms.max
          
          Location(minX, minY, Rectangle(maxX - minX, maxY - minY))
    
    logger.debug(s"Result: $result")
    result

end boundingBox
