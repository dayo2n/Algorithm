// [출처: BOJ] https://www.acmicpc.net/problem/2581

import Foundation
var M: Int = Int(readLine()!)!
var N: Int = Int(readLine()!)!

func isPrime(_ number: Int) -> Bool {
    if number < 2 { return false }
    for prime in (2...number) {
        if prime * prime > number { break }
        if number % prime == 0 { return false }
    }
    return true
}

var sum: Int = 0
var minPrime: Int = N
for number in M...N {
    if isPrime(number) {
        sum += number
        if minPrime > number { minPrime = number }
    }
}

if sum == 0 {
    print(-1)
    exit(0)
}

print(sum)
print(minPrime)
