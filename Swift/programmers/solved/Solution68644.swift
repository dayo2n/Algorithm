import Foundation

func solution(_ numbers:[Int]) -> [Int] {
    
    var answer: Set<Int> = []
    for (numberIdx, number) in numbers.enumerated() {
        for (numIdx, num) in numbers.enumerated() {
            if numberIdx != numIdx {
                answer.insert(number + num)
            }
        }
    }
    return answer.sorted().map{Int($0)}
}
