file://<WORKSPACE>/AoC-1.scala
### java.lang.StringIndexOutOfBoundsException: String index out of range: 934

occurred in the presentation compiler.

action parameters:
offset: 933
uri: file://<WORKSPACE>/AoC-1.scala
text:
```scala
import scala.io.Source

val text = for (line <- Source.fromFile("file.txt").getLines) yield line
val input = text.toVector

val digitStrings: Map[String, Int] = Map("one" -> 1, "two" -> 2, "three" -> 3, "four" -> 4, "five" -> 5, "six" -> 6, "seven" -> 7, "eight" -> 8, "nine" -> 9)

def toNums(s: String): String = 
    var result = s
    for chars <- s do
        digitStrings.foreach(i => if s.contains(i._1) then result = result.replace(i._1, i._2.toString))
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
    s.map(k => toNums(k)).map(i => nums(i)).map(_.toInt).sum@@

```



#### Error stacktrace:

```
java.base/java.lang.StringLatin1.charAt(StringLatin1.java:48)
	java.base/java.lang.String.charAt(String.java:1517)
	scala.meta.internal.mtags.CommonMtagsEnrichments$XtensionRangeParams.isWhitespace$1(CommonMtagsEnrichments.scala:84)
	scala.meta.internal.mtags.CommonMtagsEnrichments$XtensionRangeParams.trim$1$$anonfun$1(CommonMtagsEnrichments.scala:88)
	scala.Option.filter(Option.scala:319)
	scala.meta.internal.mtags.CommonMtagsEnrichments$XtensionRangeParams.trim$1(CommonMtagsEnrichments.scala:88)
	scala.meta.internal.mtags.CommonMtagsEnrichments$XtensionRangeParams.trimWhitespaceInRange(CommonMtagsEnrichments.scala:93)
	scala.meta.internal.mtags.MtagsEnrichments$.sourcePosition(MtagsEnrichments.scala:43)
	scala.meta.internal.pc.HoverProvider$.hover(HoverProvider.scala:37)
	scala.meta.internal.pc.ScalaPresentationCompiler.hover$$anonfun$1(ScalaPresentationCompiler.scala:329)
```
#### Short summary: 

java.lang.StringIndexOutOfBoundsException: String index out of range: 934