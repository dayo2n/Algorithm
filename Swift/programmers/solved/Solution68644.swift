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
    // 이중for문을 쓸 수 밖에 없는 문제인듯
    return answer.sorted().map{Int($0)}
}

// 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/68644
