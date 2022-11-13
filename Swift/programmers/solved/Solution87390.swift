
// [출처: 프로그래머스] https://school.programmers.co.kr/learn/courses/30/lessons/87390

import Foundation

func solution(_ n:Int, _ left:Int64, _ right:Int64) -> [Int] {
    var flatten: [Int] = []
    for index in Int(left)...Int(right) {
        flatten.append(max(index/n, index%n) + 1)
    }
    return flatten
}
