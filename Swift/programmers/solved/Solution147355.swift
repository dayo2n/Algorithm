
// [출처: 프로그래머스] https://school.programmers.co.kr/learn/courses/30/lessons/147355

import Foundation

func solution(_ t:String, _ p:String) -> Int {
    let interval: Int = p.count
    var cursor: Int = 0
    var answer: Int = 0
    while cursor <= (t.count - interval) {
        let target: Int = Int(t[t.index(t.startIndex, offsetBy: cursor)..<t.index(t.startIndex, offsetBy: cursor+interval)])!
        if target <= Int(p)! { answer += 1 }
        cursor += 1
    }
    return answer
}
