// [출처: 프로그래머스] https://school.programmers.co.kr/learn/courses/30/lessons/135808

import Foundation

func solution(_ k:Int, _ m:Int, _ score:[Int]) -> Int {
    var total: Int = 0
    var apple: [Int] = score.sorted()
    
    for _ in (0..<score.count / m) {
        apple.removeLast(m-1)
        total += apple.removeLast() * m
    }
    return total
}
