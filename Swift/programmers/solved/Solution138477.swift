// [출처: 프로그래머스] https://school.programmers.co.kr/learn/courses/30/lessons/138477

import Foundation

func solution(_ k:Int, _ score:[Int]) -> [Int] {
    var theHallOfFame: [Int] = []
    var presented: [Int] = []
    for minScore in score {
        if theHallOfFame.count < k {
            theHallOfFame.append(minScore)
        } else {
            if minScore > theHallOfFame[k-1] {
                theHallOfFame.removeLast()
                theHallOfFame.append(minScore)
            }
        }
        theHallOfFame = theHallOfFame.sorted(by: >)
        presented.append(theHallOfFame.last!)
    }
    return presented
}
