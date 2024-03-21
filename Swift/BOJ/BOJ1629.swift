
// [출처: BOJ] https://www.acmicpc.net/problem/1629
// 분할정복

import Foundation
let input = readLine()!.split(separator: " ").map { Int($0)! }
let (a, b, c) = (input[0], input[1], input[2])

func power(_ exp: Int) -> Int {
    if exp == 1 { return a % c }
    let value = power(exp / 2)
    if exp % 2 == 1 {
        return (value * value % c) * a % c
    }
    return value * value % c
}

print(power(b))
