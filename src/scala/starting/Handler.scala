package scala.starting

import scala.io.Source

/**
  * Created by sbelkin on 2/28/2016.
  */

object Handler {

  var rows = 0
  var cols = 0
  var grid = Array.ofDim[Integer](rows,cols)

  // Array of words, then reverse. then fix the words
  def main(args: Array[String]) {
    if (args.length < 3) {
      throw new IllegalArgumentException("The input variables must be row, colums and default file.")
    }
    rows = args(0).toInt
    cols = args(1).toInt
    grid = empty_grid()
    grid = starting_life(args(2))
    println("Staring grid:")
    printing_grid(grid)
    1 to args(3).toInt foreach { _ => life_iteration()}
  }

  def printing_grid(grid: Array[Array[Integer]]) : Unit = {
    grid.foreach(f => {
      f.foreach(i => print(i +" "))
      println()
    })
  }

  def empty_grid() : Array[Array[Integer]] = {
    val grid = Array.ofDim[Integer](rows,cols)
    for {
      i <- 0 until rows
      j <- 0 until cols
    } {grid(i)(j)=0}
    grid
  }

  def starting_life(file: String) : Array[Array[Integer]] = {
    val source = scala.io.Source.fromFile(file)
    val lines = try source.getLines.toArray finally source.close()
    lines.foreach(f=> { var temp = f.split(":"); grid(temp(0).toInt)(temp(1).toInt) = 1; })
    grid
  }

  def life_iteration() {
    val new_grid = empty_grid()
    for {
      r <- 0 until rows
      c <- 0 until cols
    } new_grid(r)(c) = handle_neighbours(r,c)
    grid = new_grid
    println("Life Iteration grid:")
    printing_grid(grid)
  }

  def handle_neighbours(r:Integer, c:Integer): Integer = {
    if (grid(r)(c) == 1) live_cell_out(count_neighbours(r,c))
    else dead_cell_out(count_neighbours(r,c))
  }

  def count_neighbours(r:Integer, c:Integer): Integer = {
    var neighbours: Integer = 0
    if (neighbour_exists(r-1,c-1)) neighbours+=grid(r-1)(c-1)
    if (neighbour_exists(r,c-1)) neighbours+=grid(r)(c-1)
    if (neighbour_exists(r+1,c-1)) neighbours+=grid(r+1)(c-1)
    if (neighbour_exists(r-1,c)) neighbours+=grid(r-1)(c)
    if (neighbour_exists(r+1,c)) neighbours+=grid(r+1)(c)
    if (neighbour_exists(r-1,c+1)) neighbours+=grid(r-1)(c+1)
    if (neighbour_exists(r,c+1)) neighbours+=grid(r)(c+1)
    if (neighbour_exists(r+1,c+1)) neighbours+=grid(r+1)(c+1)
    neighbours
  }

  def neighbour_exists(r:Integer, c:Integer): Boolean = {
    if ((0 <= r && r <= rows-1) && (0 <= c && c <= cols-1)){
      return true
    } else return false
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
