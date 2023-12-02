import scala.io.Source

@main def run = {

    val text = for (line <- Source.fromFile("input.txt").getLines) yield line
    val input = text.toVector
    var sum = 0
    
    def valid(s: String): Boolean = 
        val vec = s.split(" ").toVector
        var goodGame = true
        for i <- vec.indices do
            if vec(i).contains("green") && vec(i - 1).toInt > 13 then goodGame = false
            else if vec(i).contains("red") && vec(i - 1).toInt > 12 then goodGame = false
            else if vec(i).contains("blue") && vec(i - 1).toInt > 14 then goodGame = false
        goodGame
        

    def solution(gameVector: Vector[String]): Int =         
        gameVector.map(s => if valid(s) then sum += gameVector.indexOf(s) + 1)
        sum

    println(solution(input))

}