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
    if (args.length < 3) {
      throw new IllegalArgumentException("The input variables must be row, colums and default file.")
    }
    rows = args(0).toInt
    cols = args(1).toInt
    var grid = empty_grid()
    grid = starting_life(args(2),grid)
    println("Staring grid:")
    printing_grid(grid)
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

  def empty_grid() : Array[Array[Integer]] = {
    val grid = Array.ofDim[Integer](rows,cols)
    for {
      i <- 0 until rows
      j <- 0 until cols
    } {grid(i)(j)=0}
    grid
  }

  def starting_life(file: String, grid: Array[Array[Integer]]) : Array[Array[Integer]] = {
    val source = scala.io.Source.fromFile(file)
    val lines = try source.getLines.toArray finally source.close()
    lines.foreach(f=> { var temp = f.split(":"); grid(temp(0).toInt)(temp(1).toInt) = 1; })
    grid
  }

  def life_iteration(grid: Array[Array[Integer]]) : Array[Array[Integer]] = {
    var new_grid = empty_grid()

    grid
  }

  def count_neighbours(r:Integer, c:Integer): Integer = {
    var neighbours: Integer = 0

    neighbours
  }

  def live_cell_out(neighbours: Integer) : Integer = {
    //    Any live cell with fewer than two live neighbours dies, as if caused by under-population.
    //    Any live cell with two or three live neighbours lives on to the next generation.
    //    Any live cell with more than three live neighbours dies, as if by over-population.
    if (2 == neighbours || 3 == neighbours) {
      return 1
    }
    0
  }

  def dead_cell_out(neighbours: Integer) : Integer = {
    //    Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
    if (3 == neighbours) {
      return 1
    }
    0
  }
}
