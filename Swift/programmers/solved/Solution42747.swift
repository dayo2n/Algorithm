
// [출처] https://school.programmers.co.kr/learn/courses/30/lessons/42747#


import Foundation

func solution(_ citations:[Int]) -> Int {
    
    let sortedCitations: [Int] = citations.sorted()
    let len: Int = citations.count
    
    for index in stride(from: 0, to: len, by: 1) {
        if sortedCitations[index] >= len - index { return len - index}
    }
    return 0
}
