
// [출처: BOJ] https://www.acmicpc.net/problem/11403
/*
 DFS
 처음에 비방향 그래프로 생각해서 인접행렬의 거듭제곱으로 잘못 푼 문제
 방향성이 있다는 점만 유의하면 DFS로 쉽게 풀림 + (i, j)가 같은 경우, 처음 큐를 돌 때만 유의
 */

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
