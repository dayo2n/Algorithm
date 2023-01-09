
// [출처: BOJ] https://www.acmicpc.net/problem/11055

let N: Int = Int(readLine()!)!
let A: [Int] = readLine()!.split(separator: " ").map({Int($0)!})
var dp: [Int] = Array(repeating: 0, count: N+1)
dp[0] = A[0]

for n in 1..<N {
    var minIndex: Int = n-1
    while minIndex >= 0 {
        if A[minIndex] < A[n] && dp[n] < A[n] + dp[minIndex] {
            dp[n] = dp[minIndex] + A[n]
        }
        minIndex -= 1
    }
    
    if dp[n] == 0 { dp[n] = A[n] }
}

print(dp.max()!)
