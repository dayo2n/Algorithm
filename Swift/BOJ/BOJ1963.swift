
// [출처: BOJ] https://www.acmicpc.net/problem/1963
// 에라토스테네스의 체, BFS

import Foundation

let MAX_NUMBER = 10_000
/* 소수 먼저 구하기 */
var primeNumber = Array(repeating: true, count: MAX_NUMBER)
primeNumber[0] = false
primeNumber[1] = false
for number in 2..<MAX_NUMBER {
    if !primeNumber[number] { continue }
    var multiple = number * 2
    while multiple < MAX_NUMBER {
        primeNumber[multiple] = false
        multiple += number
    }
}

func intToChar(_ target: Int) -> Character {
    Character("\(target)")
}

func arrToInt(_ target: [Character]) -> Int {
    Int(String(target))!
}


let testcase = Int(readLine()!)!
for _ in 0..<testcase {
    let input = readLine()!.split(separator: " ").map { Int($0)! }
    let from = input[0]
    let to = input[1]
    
    var queue = [Int]()
    var visited = Array(repeating: false, count: MAX_NUMBER)
    var distance = Array(repeating: -1, count: MAX_NUMBER)
    queue.append(from)
    distance[from] = 0
    visited[from] = true
    
    while !queue.isEmpty {
        let topNumber = queue.removeFirst()
        var numberArray = Array(String(topNumber))
        for index in 0..<4 {
            for targetNumber in 0..<10 {
                if index == 0, targetNumber == 0 { continue }
                let origin = numberArray[index]
                numberArray[index] = intToChar(targetNumber)
                let target = arrToInt(numberArray)
                if !visited[target], primeNumber[target] {
                    visited[target] = true
                    distance[target] = distance[topNumber] + 1
                    queue.append(target)
                }
                numberArray[index] = origin
            }
        }
    }
    print(distance[to] == -1 ? "Impossible" : distance[to])
}
