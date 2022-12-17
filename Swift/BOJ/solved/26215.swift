// [출처: BOJ] https://www.acmicpc.net/problem/26215

import Foundation

let N: Int = Int(readLine()!)!
let stringA: String = readLine()!
var a: [Int] = stringA.split(separator: " ").map{Int($0)!}.sorted(by: >)

if a[0] > 1440 {
    print(-1)
    exit(0)
}

var time: Int = 0
var max: Int = 0
var cursor: Int = 1

while cursor < a.count {
    print(a, max, cursor, time)
    
    // 두 집 눈을 각각 1씩 치움
    time += min(a[max], a[cursor])
    
    if a[max] > a[cursor] {
        a[max] -= a[cursor]
        a[cursor] = 0
    } else if a[max] < a[cursor] {
        a[cursor] -= a[max]
        a[max] = 0
    } else {
        a[max] = 0
        a[cursor] = 0
    }
    
    // 다른 집으로 이동
    if a[max] == 0 {
        if a[cursor] == 0 {
            max = cursor + 1
            cursor += 1
        } else { max = cursor }
    }
    cursor += 1
}

// 남은 한 집의 눈을 1씩 치움
if max < a.count {
    time += a[max]
    max += 1
}

print(time > 1440 ? -1 : time)

// 약 55%에서 틀리는 코드

//5
//9 8 7 6 6
//answer 18, output 21

/*
8: 1 0 7 6 6
9: 0 0 6 6 6
15: 0 0 0 0 6
21: 0 0 0 0 0


8: 1 0 7 6 6 -> 7 6 6 1 0
14: 1 0 6 1 0 -> 6 1 1 0 0
15: 5 0 1 0 0
16: 4 0 0 0 0
20: 0 0 0 0 0
*/
