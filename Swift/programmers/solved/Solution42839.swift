// 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/42839

import Foundation

func solution(_ numbers:String) -> Int {
    var candidates = Set<Int>()
    let numbersArray = Array(numbers).map({ String($0) })
    var visited = Array(repeating: false, count: numbers.count)
    
    // 가능한 수의 조합
    func combination(_ currentNumbers: [String], _ targetCount: Int) {
        if currentNumbers.count == targetCount {
            let getNumber = currentNumbers.reduce("",+)
            candidates.insert(Int(getNumber)!)
        }
        for index in 0..<numbers.count {
            if visited[index] { continue }
            visited[index] = true
            combination(currentNumbers + [numbersArray[index]], targetCount)
            visited[index] = false
        }
    }
    for count in 1...numbers.count {
        combination([], count)
    }
    
    // 소수 구하기
    let maxNumber = candidates.max()!
    var isPrime = Array(repeating: true, count: maxNumber + 1)
    isPrime[0] = false
    isPrime[1] = false
    for target in 2..<isPrime.count {
        if !isPrime[target] { continue }
        var next = 2 * target
        while next <= maxNumber {
            isPrime[next] = false
            next += target
        }
    }
    
    // 소수 개수 구하기
    var countOfPrime = 0
    candidates.forEach {
        if isPrime[$0] { countOfPrime += 1 }
    }
    return countOfPrime
}
