/*
 dfs + 재귀 문제
 두 문자열 배열을 알파벳순으로 빠른걸 탐색해야 해서 흠칫했는데 zip 써주니까 바로 풀림ㅎ
 그리고 dfs에서 결과값 리턴할 때 3중 맵핑하는데 신기하게도 시간초과가 안났다 ... 하지만 개선하는 것이 좋을듯
 */

import Foundation

func solution(_ tickets:[[String]]) -> [String] {
    var ways = [String: [String]]()
    var visited = [String: [Bool]]()
    for ticket in tickets {
        let (from, to) = (ticket[0], ticket[1])
        if ways[from] != nil {
            ways[from]!.append(to)
            visited[from]!.append(false)
        } else {
            ways[from] = [to]
            visited[from] = [false]
        }
    }
    
    var returnResults = [String]()
    func dfs(_ from: String, _ visited: [String: [Bool]], _ results: [String]) {
        if results.count == tickets.count + 1,
           visited.map { $0.value }.flatMap { $0 }.filter { !$0 }.isEmpty {
            if !returnResults.isEmpty {
                for (left, right) in zip(returnResults, results) {
                    if left == right {
                        continue
                    } else if left < right {
                        break
                    } else {
                        returnResults = results
                        break
                    }
                }
            } else {
                returnResults = results
            }
        }
        var visited = visited
        
        guard let ways = ways[from] else { return }
        for (index, to) in ways.enumerated() {
            if visited[from]![index] { continue }
            visited[from]![index] = true
            dfs(to, visited, results + [to])
            visited[from]![index] = false
        }
    }
    
    dfs("ICN", visited, ["ICN"])
    return returnResults
}
