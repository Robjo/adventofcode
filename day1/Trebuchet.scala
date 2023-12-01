import scala.io.Source

val text = for (line <- Source.fromFile("file.txt").getLines) yield line
val input = text.toVector

val digitStrings: Map[String, Int] = Map("one" -> 1, "two" -> 2, "three" -> 3, "four" -> 4, "five" -> 5, "six" -> 6, "seven" -> 7, "eight" -> 8, "nine" -> 9)

def toNums(s: String): String = 
    var result = s
    for chars <- s do
        digitStrings.foreach(i => if s.contains(i._1) then result = result.replace(i._1, i._1(0) + i._2.toString + i._1(i._1.length() - 1)))
    result    

def nums(s: String): String = 
    var first = ""
    var second = ""
    var n = 0
    var m = 0
    while first.isEmpty() do
        if s(n).isDigit then first = s(n).toString() else first = ""; n += 1

    while second.isEmpty() do
        if s.reverse(m).isDigit then second = s.reverse(m).toString() else second = ""; m += 1
    
    first + second

def solution(s: Vector[String]): Int = 
    s.map(k => toNums(k)).map(i => nums(i)).map(_.toInt).sum
