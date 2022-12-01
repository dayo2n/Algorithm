
// [출처: 프로그래머스] https://school.programmers.co.kr/learn/courses/30/lessons/131127

import Foundation

func solution(_ want:[String], _ number:[Int], _ discount:[String]) -> Int {
    var enable: Int = 0
    for item in 0..<(discount.count-9) {
        for (index, value) in want.enumerated() {
            if discount[item..<item+10].contains(value) {
                if discount[item..<item+10].filter{$0==value}.count != number[index] { break }
            } else { break }
            
            if index == want.count - 1 { enable += 1}
        }
    }
    return enable
}
