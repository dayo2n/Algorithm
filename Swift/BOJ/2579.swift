
// [출처: BOJ] https://www.acmicpc.net/problem/2579

let N: Int = Int(readLine()!)!
var step: [Int] = []

step.append(0)
for _ in 0..<N {
    step.append(Int(readLine()!)!)
}

var dp: [Int] = Array(repeating: 0, count: N+1)

for n in 0...N {
    switch n {
    case 0:
        dp[n] = 0
    case 1:
        dp[n] = step[1]
    case 2:
        dp[n] = step[1] + step[2]
    default:
        dp[n] = step[n] + max(dp[n-3] + step[n-1], dp[n-2])
    }
}

print(dp[N])
