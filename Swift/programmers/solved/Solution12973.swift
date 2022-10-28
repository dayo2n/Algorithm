// 시간초과 및 효율성 테스트
import Foundation

func solution(_ s:String) -> Int{
    var str: [Character] = Array(s)
    var ptr: Int = 0
    while str.count > 0 {
        if ptr + 1 >= str.count { break }
        if str[ptr] == str[ptr + 1] {
            str.remove(at: ptr)
            str.remove(at: ptr)
            ptr = 0
        } else { ptr += 1 }
    }
    return str.count == 0 ? 1 : 0
}

// Dictionary를 스택처럼 사용하여 통과
import Foundation

func solution(_ s:String) -> Int{
    var stack:[Character] = []
    for str in s {
        if stack.count > 0 && stack.last == str {
            stack.removeLast()
        } else { stack.append(str) }
    }
    return stack.count == 0 ? 1 : 0
}
