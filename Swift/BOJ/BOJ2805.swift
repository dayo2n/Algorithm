
// [출처: BOJ] https://www.acmicpc.net/problem/2805
// 이분탐색

let input = readLine()!.split(separator: " ").map{ Int($0)! }
let (n, m) = (input[0], input[1])
let trees = readLine()!.split(separator: " ").map{ Int($0)! }

var left = trees.max()! - m
left = left < 0 ? 1 : left
var right = trees.max()!
var maxResult = -1

while left < right {
    let mid = Int((left + right) / 2)
    let enableToGet = trees.map { $0 - mid }.map { $0 < 0 ? 0 : $0 }.reduce(0,+)
    if enableToGet >= m {
        maxResult = max(maxResult, mid)
    }
    if enableToGet > m {
        left = mid + 1
    } else {
        right = mid
    }
}

print(maxResult)
