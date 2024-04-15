
// [출처: BOJ] https://www.acmicpc.net/problem/25418
/*
 DP
 */

let input = readLine()!.split(separator: " ").map { Int($0)! }
var (A, K) = (input[0], input[1])

/*
 연산 1: 정수 A + 1
 연산 2: 정수 A * 2
 
 A를 K로 만드는 최소 횟수
 */

var dp = Array(repeating: 0, count: 1_000_001)
dp[A] = 0

for index in A+1...K {
    dp[index] = dp[index - 1] + 1
    if index % 2 == 0, index / 2 >= A {
        dp[index] = min(dp[index], dp[index / 2] + 1)
    }
}

print(dp[K])
