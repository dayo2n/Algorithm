
import Foundation

func solution(_ answers:[Int]) -> [Int] {
    
    let patterns : [Int : [Int]] = [1: [1, 2, 3, 4, 5],
                                    2: [2, 1, 2, 3, 2, 4, 2, 5],
                                    3: [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]]
    
    var scores : [Int : Int] = [1: 0, 2: 0, 3: 0]
    
    for (answerIdx, answer) in answers.enumerated() {
        if answer == patterns[1]![answerIdx % patterns[1]!.count] { scores[1] = scores[1]! + 1}
        if answer == patterns[2]![answerIdx % patterns[2]!.count] { scores[2] = scores[2]! + 1}
        if answer == patterns[3]![answerIdx % patterns[3]!.count] { scores[3] = scores[3]! + 1}
    }
    
    let maxScore = scores.max{ $0.value < $1.value }!.value
    return [Int](scores.filter{ $0.value == maxScore }.keys).sorted()
}
