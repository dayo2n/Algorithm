
// [출처: BOJ] https://www.acmicpc.net/problem/1072
/*
 왜인지 모르겠지만 50일 때도 -1이 나온다고 생각해서 여러 번 틀림
 그리고 부동소수점때문에, 연산 순서에 따라 100 * (Y / X)랑 100 * Y / X의 계산값이 다름
 */

import Foundation
let input = readLine()!.split(separator: " ").map { Int($0)! }
let (X, Y, Z) = (input[0], input[1], getAverage(input[1], input[0]))
if Z >= 99 {
    print(-1)
    exit(0)
}

var (left, right) = (1, X)
var minRound = right

while left <= right {
    let mid = (left + right) / 2
    if getAverage(Y + mid, X + mid) > Z {
        minRound = min(minRound, mid)
        right = mid - 1
    } else {
        left = mid + 1
    }
}
print(minRound)

func getAverage(_ top: Int, _ bottom: Int) -> Int {
    Int(100.0 * Double(top) / Double(bottom))
}
