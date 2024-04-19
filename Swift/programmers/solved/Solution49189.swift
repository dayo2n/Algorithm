import Foundation

func solution(_ n:Int, _ edge:[[Int]]) -> Int {
    var graph = Array(repeating: [Int](), count: n + 1)
    var distance = Array(repeating: Int.max, count: n + 1)
    for vertex in edge {
        let (from, to) = (vertex[0], vertex[1])
        graph[from].append(to)
        graph[to].append(from)
    }
    var queue = [(node: Int, count: Int)]()
    graph[1].forEach { queue.append(($0, 1)) }
    var visited = Array(repeating: false, count: n + 1)
    var maxDistance = -1
    while !queue.isEmpty {
        let first = queue.removeFirst()
        let (node, count) = (first.node, first.count)
        if visited[node] || node == 1 { continue }
        visited[node] = true
        graph[node].forEach {
            if !visited[$0] || $0 > 1 {
                distance[node] = min(distance[node], count + 1)
                maxDistance = max(distance[node], maxDistance)
                queue.append(($0, count + 1))
            }
        }
    }
    return distance.filter { $0 == maxDistance }.count
}
