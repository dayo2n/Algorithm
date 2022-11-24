// [출처: 프로그래머스] https://school.programmers.co.kr/learn/courses/30/lessons/92335

import Foundation

func isPrime(_ n: Int) -> Bool {
    var divisor: Int = 2
    if n < divisor { return false }
    if n == divisor { return true }
    while divisor <= Int(sqrt(Double(n))) {
        if n % divisor == 0 { return false }
        divisor += 1
    }
    return true
}

func solution(_ n:Int, _ k:Int) -> Int {
    return String(n, radix: k).split(separator: "0").filter{isPrime(Int($0)!)}.count
} 
