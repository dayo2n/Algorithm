
// [출처: BOJ] https://www.acmicpc.net/problem/2805
// dp, 점화식 찾기 어려웠다 ...

import Foundation
let input = Int(readLine()!)!
if input == 1 {
    print(9)
    exit(0)
}
let mod = 1_000_000_000

var dp = Array(repeating: Array(repeating: 0, count: 10), count: input + 1)
dp[1] = [0, 1, 1, 1, 1, 1, 1, 1, 1, 1]

for order in 2..<input+1 {
    for current in 0..<10 {
        let left = current == 0 ? 0 : dp[order - 1][current - 1]
        let right = current == 9 ? 0 : dp[order - 1][current + 1]
        dp[order][current] = (left + right) % mod
    }
}

print(dp[input].reduce(0, +) % mod)
