// [출처: 프로그래머스] https://school.programmers.co.kr/learn/courses/30/lessons/140108

import Foundation

func solution(_ s:String) -> Int {
    var cur: Int = 0
    var separated: Int = 0
    while cur < s.count {
        let x: String = String(s[s.index(s.startIndex, offsetBy: cur)])
        var numX: Int = 1
        var numOthers: Int = 0
        if cur == s.count - 1 {
            separated += 1
            break
        }
        for value in s[s.index(s.startIndex, offsetBy: cur+1)..<s.endIndex] {
            cur += 1
            if String(value) != x { numOthers += 1 }
            else { numX += 1 }
            if numX == numOthers { break }
        }
        cur += 1
        separated += 1
    }
    return separated
}
