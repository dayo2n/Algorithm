let N = Int(readLine()!)!
var dp = Array(repeating: Array(repeating: 0, count: 3), count: N)
var cost = [[Int]]()

for n in 0..<N {
    cost.append(readLine()!.split(separator: " ").map { Int($0)! })
    if n == 0 {
        dp[0] = cost[0]
    }
}

var minCost = Int.max
for rgb in 0..<3 {
    for color in 0..<3 {
        dp[0][color] = rgb == color ? cost[0][color] : 1_001
    }
    for index in 1..<N {
        dp[index][0] = min(dp[index - 1][1], dp[index - 1][2]) + cost[index][0]
        dp[index][1] = min(dp[index - 1][0], dp[index - 1][2]) + cost[index][1]
        dp[index][2] = min(dp[index - 1][0], dp[index - 1][1]) + cost[index][2]
    }
    for index in dp[N-1].indices {
        if index == rgb { continue }
        minCost = min(minCost, dp[N-1][index])
    }
}
print(minCost)
