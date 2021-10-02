object PrintMacro:
  import scala.quoted._

  inline def printSingle(inline expr: Any): Unit =
    ${printSingleImpl('expr)}
  
  private def printSingleImpl(expr: Expr[Any])(using Quotes): Expr[Unit] =
    '{ println("Value of " + ${Expr(expr.show)} + " is " + $expr) }
  
