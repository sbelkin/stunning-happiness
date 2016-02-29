package scala.starting

/**
  * Created by sbelkin on 2/28/2016.
  */
object Handler {

  def main(args: Array[String]) {
    if (args.length < 1) {
      throw new IllegalArgumentException("The input variables must be at least 1 to read in file.")
    }
    print(args(0))
    val source = scala.io.Source.fromFile(args(0))
    val lines = try source.mkString finally source.close()
    println(lines)
  }


  def reverse_words(args: String) : String = {

    ""
  }
}
