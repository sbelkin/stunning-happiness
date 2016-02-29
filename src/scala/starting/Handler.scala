package scala.starting

import javafx.beans.binding.When

/**
  * Created by sbelkin on 2/28/2016.
  */

object Handler {

  def main(args: Array[String]) {
    if (args.length < 1) {
      throw new IllegalArgumentException("The input variables must be at least 1 to read in file.")
    }
    val source = scala.io.Source.fromFile(args(0))
    val lines = try source.mkString finally source.close()
    val output = reverse_words(lines)

    if(args.length < 2){
      val source = scala.io.Source.fromFile(args(1))
      val testlines = try source.mkString finally source.close()
      assert(output == testlines)
    } else {
      println("No test input in second args.")
      println(output)
    }
  }

//  This is not efficient.
//  def reverse_words_bad(args: String) : String = {
//    val split = args.split(" ").reverse
//    var reversed = ""
//    split.foreach( i => reversed += i + " " )
//    reversed
//  }

  //we will now want to swap word locations. to do this size of words will matter and location between each space.
  def reverse_words(args: String) : String = {

    ""
  }
}
