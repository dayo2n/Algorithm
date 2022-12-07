
// [출처: 프로그래머스] https://school.programmers.co.kr/learn/courses/30/lessons/12987


// 효율성 테스트에서 시간초과가 난 코드
import Foundation

func solution(_ a:[Int], _ b:[Int]) -> Int {
    var sortedA: [Int] = a.sorted(by: >)
    var sortedB: [Int] = b.sorted(by: <)
    var score: Int = 0
    
    while !sortedA.isEmpty {
        let itemA = sortedA.removeLast()
        var itemB: Int?
        for (index, value) in sortedB.enumerated() {
            if value > itemA {
                itemB = sortedB.remove(at: index)
                break
            }
        }
        if let _ = itemB { score += 1 }
        else { sortedB.removeFirst() }
    }
    return score
}


// 인덱스를 이용해서 시간초과를 줄이는 방법

import Foundation

func solution(_ a:[Int], _ b:[Int]) -> Int {
    var sortedA: [Int] = a.sorted()
    var sortedB: [Int] = b.sorted()
    var cursorA: Int = sortedA.count - 1
    var cursorB: Int = sortedB.count - 1
    var score: Int = 0
    
    while cursorA > -1 {
        if sortedA[cursorA] < sortedB[cursorB] {
            cursorB -= 1
            score += 1
        }
        cursorA -= 1
    }
    return score
}
