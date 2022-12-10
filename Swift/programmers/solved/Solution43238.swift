// [출처: 프로그래머스] https://school.programmers.co.kr/learn/courses/30/lessons/43238

import Foundation

func solution(_ n:Int, _ times:[Int]) -> Int64 {
    var min: Int = 1
    var max: Int = times.max()! * n
    var screenedTime: Int = 0
    
    while min <= max {
        let mid: Int = (min + max) / 2
        let maxPeople: Int = times.map{mid / $0}.reduce(0,+)
        
        if maxPeople >= n {
            screenedTime = mid
            max = mid - 1
        } else { min = mid + 1 }
    }
    return Int64(screenedTime)
}
