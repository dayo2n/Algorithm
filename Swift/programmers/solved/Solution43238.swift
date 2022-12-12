// [출처: 프로그래머스] https://school.programmers.co.kr/learn/courses/30/lessons/43238


/*
 이분탐색으로 해결
 */

import Foundation

func solution(_ n:Int, _ times:[Int]) -> Int64 {
    var min: Int = 1
    var max: Int = times.max()! * n // 1을 left, 심사에 가장 오래걸리는 시간 * n을 right로 검사 시작
    var screenedTime: Int = 0
    
    while min <= max {
        let mid: Int = (min + max) / 2
        // mid 값을 각 심사시간으로 나누어 심사받을 수 있는 총 시간을 구함
        let maxPeople: Int = times.map{mid / $0}.reduce(0,+)
        
        // 총 시간이 중간값보다 많거나 같으면 심사 최소값은 mid, max = mid - 1
        if maxPeople >= n {
            screenedTime = mid
            max = mid - 1
        } else { min = mid + 1 }
        // 총 시간이 중간값보다 적다면 min = mid + 1
    }
    return Int64(screenedTime)
}
