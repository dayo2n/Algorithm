
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
            // B의 숫자가 더 크면 커서 B를 움직이고, 점수 획득
            cursorB -= 1
            score += 1
        }
        cursorA -= 1
    }
    return score
}

/*
 while문 안에서 for문을 또 돌면서 값을 순차적으로 검사하는 게 아니라,
 두 배열 모두 오름차순 정렬하고 인덱스만 조정하면서 값을 비교는 방법으로 해결
*/
