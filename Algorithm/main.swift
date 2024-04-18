let N = Int(readLine()!)!

var matrix = [[Int]]()
for _ in 0..<N {
    matrix.append(readLine()!.split(separator: " ").map { Int($0)! })
}

var results = matrix
for i in 0..<N {
    for j in 0..<N {
        results[i][j] = dfs(i, j)
    }
}

func dfs(_ start: Int, _ end: Int) -> Int {
    var queue = [Int]()
    var visited = Array(repeating: Array(repeating: false, count: N), count: N)
    var justStarted = true
    queue.append(start)
    while !queue.isEmpty {
        let first = queue.removeFirst()
        if first == end, !justStarted { return 1 }
        justStarted = false
        matrix[first].enumerated().forEach {
            if $1 == 1 {
                if !visited[first][$0] {
                    queue.append($0)
                    visited[first][$0] = true
                }
            }
        }
    }
    return 0
}

results.forEach {
    $0.forEach {
        print($0, terminator: " ")
    }
    print()
}
