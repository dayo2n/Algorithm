import Foundation

func solution(_ begin:String, _ target:String, _ words:[String]) -> Int {
    if !words.contains(target) {
        return 0
    }
    var visited = Array(repeating: false, count: words.count)
    var shortest = words.count
    func dfs(_ visited: [Bool], _ current: String, _ count: Int) {
        if current == target {
            shortest = min(shortest, count)
            return
        }
        for (index, word) in words.enumerated() {
            if visited[index] { continue }
            if enableToChange(word, current) {
                var updateVisited = visited
                updateVisited[index] = true
                dfs(updateVisited, word, count + 1)
            }
        }
    }
    dfs(visited, begin, 0)
    return shortest
}

func enableToChange(_ from: String, _ to: String) -> Bool {
    var diff = 0
    for (index, fromWord) in Array(from).enumerated() {
        if fromWord == to[to.index(to.startIndex, offsetBy: index)] {
            diff += 1
        }
    }
    return (from.count - diff) == 1
}
