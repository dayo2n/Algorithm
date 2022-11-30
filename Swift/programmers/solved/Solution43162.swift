// [출처: 프로그래머스] https://school.programmers.co.kr/learn/courses/30/lessons/43162

import Foundation

func solution(_ n:Int, _ computers:[[Int]]) -> Int {
    var networks: Int = 0
    var visited: [Bool] = Array(repeating: false, count: n)
    
    func dfs(_ index: Int) {
        visited[index] = true
        for other in 0..<n {
            if computers[index][other] == 1 && !visited[other] { dfs(other) }
        }
    }
    
    for index in 0..<n {
        if !visited[index] {
            networks += 1
            dfs(index)
        }
    }
    
    return networks
}
