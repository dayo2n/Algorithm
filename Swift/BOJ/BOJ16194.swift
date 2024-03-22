
// [출처: BOJ] https://www.acmicpc.net/problem/16194
// DP

let N = Int(readLine()!)!
let cards = readLine()!.split(separator: " ").map { Int($0)! }
var dp = Array(repeating: 0, count: cards.count + 1)
dp[1] = cards[0]

for index in 2..<dp.count {
    dp[index] = cards[index - 1]
    for number in 1..<index {
        dp[index] = min(dp[index], dp[index - number] + dp[number])
    }
}

print(dp[N])
