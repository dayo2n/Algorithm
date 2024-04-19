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
    print(ways)
    
    var returnResults = [String]()
    func dfs(_ from: String, _ visited: [String: [Bool]], _ results: [String]) {
//        print(results)
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

//print(solution([["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]))
print(solution([["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]))
