

/* stack과 약간의 로직 */
import Foundation

func solution(_ number:String, _ k:Int) -> String {
    var array = Array(number)
    var rest = k
    var stack = [Character]()
    
    for target in array {
        while let last = stack.last, rest > 0, target > last {
            stack.popLast()
            rest -= 1
        }
        stack.append(target)
    }
    stack.removeLast(rest)
    return String(stack)
}
