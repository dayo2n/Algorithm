// [출처: 프로그래머스] https://school.programmers.co.kr/learn/courses/30/lessons/133502#

import Foundation

func solution(_ ingredient:[Int]) -> Int {
    var hamburger: Int = 0
    var remaining: [Int] = []
    
    for item in ingredient {
        
        remaining.append(item)
        
        let len: Int = remaining.count
        if len < 4 || item != 1 { continue }
        
        if remaining[len-4..<len] == [1, 2, 3, 1] {
            hamburger += 1
            remaining = Array(remaining[0..<len-4])
        }
    }
    return hamburger
}
