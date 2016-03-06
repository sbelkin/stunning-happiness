package scala.starting

import scala.io.Source

/**
  * Created by sbelkin on 2/28/2016.
  */

object Handler {

  var rows = 0
  var cols = 0

  // Array of words, then reverse. then fix the words
  def main(args: Array[String]) {
    if (args.length < 2) {
      throw new IllegalArgumentException("The input variables must be at least 1 to read in file.")
    }
//    starting_life(source)
//    var grid: Array[Array[Integer]] = new Array[Array[Integer]]();
    rows = args(0).toInt
    cols = args(1).toInt
    var grid = empty_grid()
    grid = starting_life(args(2),grid)
    printing_grid(grid)
  }

  def empty_grid() : Array[Array[Integer]] = {
    val grid = Array.ofDim[Integer](rows,cols)
    for {
      i <- 0 until rows
      j <- 0 until cols
    } {grid(i)(j)=0}
    grid
  }

  def printing_grid(grid: Array[Array[Integer]]) : Unit = {
    grid.foreach(f => {
      f.foreach(i => print(i +" "))
      println()
    })
  }

  def printing_grid_alt(grid: Array[Array[Integer]]) : Unit = {
    for {
      i <- 0 until rows
      j <- 0 until cols
    } println(s"($i)($j) =${grid(i)(j)}")
  }

  def starting_life(file: String, grid: Array[Array[Integer]]) : Array[Array[Integer]] = {
    val source = scala.io.Source.fromFile(file)
    val lines = try source.getLines.toArray finally source.close()
    lines.foreach(f=> { var temp = f.split(":"); grid(temp(0).toInt)(temp(1).toInt) = 1; })
    grid
  }
}
