
// [출처: BOJ] https://www.acmicpc.net/problem/14916

import Foundation

let n: Int = Int(readLine()!)!
var startWith: Int = (n / 5)
var rest: Int = n % 5

if rest == 0 {
    print(startWith)
    exit(0)
}

if startWith == 0 {
    print((rest % 2 == 0) ? (rest / 2) : -1)
    exit(0)
}

while rest > 0 {
    if rest % 2 == 0 {
        print(startWith + (rest / 2))
        break
    } else {
        if startWith > 0 {
            startWith -= 1
            rest += 5
        } else {
            print(-1)
            break
        }
    }
}

