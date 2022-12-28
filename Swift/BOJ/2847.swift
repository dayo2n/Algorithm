
// [출처: BOJ] https://www.acmicpc.net/problem/2847

import Foundation

let N: Int = Int(readLine()!)!
var scores: [Int] = []

for _ in 0..<N {
    scores.append(Int(readLine()!)!)
}

var reduced: Int = 0
for (index, score) in scores.reversed().enumerated() {
    if index == 0 { continue }
    
    if score >= scores[scores.count - index] {
        let reduce: Int = score - scores[scores.count - index] + 1
        reduced += reduce
        scores[scores.count - index - 1] -= reduce
    }
}

print(reduced)
