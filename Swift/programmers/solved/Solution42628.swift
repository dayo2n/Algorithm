// [출처: 프로그래머스] https://school.programmers.co.kr/learn/courses/30/lessons/42628

import Foundation

func solution(_ operations:[String]) -> [Int] {
    var queue: [Int] = []
    for operation in operations {
        let splitOrder: [String] = operation.split(separator: " ").map{String($0)}
        if splitOrder[0] == "I" { // "Insert"
            queue.append(Int(splitOrder[1])!)
            queue = queue.sorted()
        } else { // "Delete"
            if queue.count == 0 { continue }
            if splitOrder[1] == "1" { queue.removeLast() }
            else { queue.removeFirst() }
        }
    }
    return queue.isEmpty ? [0, 0] : [queue.max()!, queue[0]]
}
