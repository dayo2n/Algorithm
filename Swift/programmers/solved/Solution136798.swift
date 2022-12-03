// [출처: 프로그래머스] https://school.programmers.co.kr/learn/courses/30/lessons/136798

import Foundation

func solution(_ number:Int, _ limit:Int, _ power:Int) -> Int {
    var weapon: [Int] = []
    for knight in 1...number {
        var count: Int = 0
        for factor in 1...Int(sqrt(Double(knight))) {
            if knight % factor == 0 {
                if knight / factor == factor { count += 1 }
                else { count += 2 }
            }
        }
        if count > limit { weapon.append(power) }
        else { weapon.append(count) }
    }
    return weapon.reduce(0,+)
}
