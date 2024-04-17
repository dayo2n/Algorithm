
// [출처: BOJ] https://www.acmicpc.net/problem/9465
/*
DP
 */

let testcase = Int(readLine()!)!
for _ in 0..<testcase {
    let n = Int(readLine()!)!
    var stickers = [[Int]]()
    for _ in 0..<2 {
        stickers.append(readLine()!.split(separator: " ").map { Int($0)! })
    }
    if n == 1 {
        print(max(stickers[0][0], stickers[1][0]))
        continue
    }
    
    var dp = Array(repeating: Array(repeating: 0, count: n), count: 2)
    dp[0][0] = stickers[0][0]
    dp[0][1] = stickers[0][1] + stickers[1][0]
    dp[1][0] = stickers[1][0]
    dp[1][1] = stickers[1][1] + stickers[0][0]
    for index in 2..<n {
        dp[0][index] = max(dp[1][index - 1], dp[1][index - 2]) + stickers[0][index]
        dp[1][index] = max(dp[0][index - 1], dp[0][index - 2]) + stickers[1][index]
    }
    print(max(dp[0][n-1], dp[1][n-1]))
}
