
// [출처: BOJ] https://www.acmicpc.net/problem/2960

import Foundation

var input: [Int] = readLine()!.split(separator: " ").map{Int($0)!}
let N: Int = input[0]
let K: Int = input[1]
var numArray = Array(0...(N + 1))
var erased: Int = 0

for i in 2...N {
    if numArray[i] == 0 {
        continue
    }
    
    for j in stride(from: i, through: N, by: i) {
        if numArray[j] == 0 { continue }
        erased += 1
        if erased == K {
            print(j)
            exit(0)
        }
        numArray[j] = 0;
    }
}
