
// [출처: BOJ] https://www.acmicpc.net/problem/1904
/*
DP
 */

let N = Int(readLine()!)!
let MOD = 15_746
var fibo = [Int]()
fibo.append(1)
fibo.append(1)

if N > 1 {
    for index in 2...N {
        fibo.append((fibo[index - 1] + fibo[index - 2]) % MOD)
    }
}

print(fibo[N])
