import Foundation

func solution(_ s:String) -> Bool
{
    var openBracket: Int = 0
    
    for bracket in s {
        openBracket += bracket == "(" ? 1 : -1
        if openBracket < 0 { break }
      }
    
    return openBracket == 0 ? true : false
}
