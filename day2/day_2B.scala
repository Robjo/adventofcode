import scala.io.Source

@main def run_2 = {

    val text = for (line <- Source.fromFile("input.txt").getLines) yield line
    val input = text.toVector
    
    def valid(s: String): Int = 
        val vec = s.split(" ").toVector
        var green: Int = 0
        var blue: Int = 0
        var red: Int = 0
        for i <- vec.indices do
            if vec(i).contains("green") && vec(i - 1).toInt > green then green = vec(i - 1).toInt
            else if vec(i).contains("red") && vec(i - 1).toInt > red then red = vec(i - 1).toInt
            else if vec(i).contains("blue") && vec(i - 1).toInt > blue then blue = vec(i - 1).toInt
        green * blue * red
        

    def solution(gameVector: Vector[String]): Int =         
        gameVector.map(s => valid(s)).sum

    println(solution(input))

}