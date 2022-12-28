
// [출처: BOJ] https://www.acmicpc.net/problem/2217
import Foundation

var N: Int = Int(readLine()!)!
var ropes: [Int] = []

for _ in 0..<N {
    ropes.append(Int(readLine()!)!)
}

ropes = ropes.sorted()
var max: Int = 0
for (index, rope) in ropes.enumerated() {
    let curMax: Int = rope * (N - index)
    if curMax > max {
        max = curMax
    }
}

print(max)

