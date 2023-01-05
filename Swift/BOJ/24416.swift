
// [출처: BOJ] https://www.acmicpc.net/problem/24416

let n: Int = Int(readLine()!)!

var dp: [Int] = Array(repeating: 0, count: n+1)

func fibonacci(_ n: Int) -> Int {
    for index in 1...n {
        if index < 3 { dp[index] = 1 }
        else { dp[index] = dp[index - 1] + dp[index - 2] }
    }
    return dp[n]
}

print(fibonacci(n), n-2)
