
// [출처:: 프로그래머스] https://school.programmers.co.kr/learn/courses/30/lessons/49994

import Foundation
func solution(_ dirs:String) -> Int {
    var reached: [(Int, Int, Int, Int)] = [] // x, y, prev x, prev y
    var curPosition: (Int, Int) = (0, 0)
    for dir in dirs {
        var prevPosition: (Int, Int) = curPosition
        switch String(dir) {
            case "U":
                curPosition.1 += 1
            case "D":
                curPosition.1 -= 1
            case "R":
                curPosition.0 += 1
            case "L":
                curPosition.0 -= 1
            default:
                break
        }
        if curPosition.0 < -5 || curPosition.0 > 5 || curPosition.1 < -5 || curPosition.1 > 5 {
            curPosition = prevPosition
            continue
        }
        var newReached: (Int, Int, Int, Int) = (curPosition.0, curPosition.1, prevPosition.0, prevPosition.1)
        if !reached.contains(where: {$0 == newReached}) && !reached.contains(where: {$0 == (prevPosition.0, prevPosition.1, curPosition.0, curPosition.1)}) { reached.append(newReached) }
    }
    return reached.count
}
