
// [출처: BOJ] https://www.acmicpc.net/problem/1647
/*
 graph를 2차원 배열로 선언했다가 메모리초과,
 모든 도시에 대해 min cost를 구했다가 시간초과,
 X에서 X로 가는 경우를 포함시켜 출력했다가 틀렸었음
 아래는 그 반례
 input
 4 4 2 1
 1 2
 1 3
 3 4
 2 1
 
 output
 1
 4
 
 answer
 4
 */

var input = readLine()!.split(separator: " ").map { Int($0)! }
let (N, M, K, X) = (input[0], input[1], input[2], input[3])

var graph = Array(repeating: [Int](), count: N + 1)
for _ in 0..<M {
    input = readLine()!.split(separator: " ").map { Int($0)! }
    let from = input[0], to = input[1]
    graph[from].append(to)
}

var minimumDistance = Array(repeating: Int.max, count: N + 1)
var queue = [(city: Int, cost: Int)]()
var visited = Array(repeating: false, count: N + 1)
queue.append((X, 0))
while !queue.isEmpty {
    let current = queue.removeFirst()
    if current.cost > K { continue }
    graph[current.city].forEach { next in
        minimumDistance[next] = min(minimumDistance[next], current.cost + 1)
        if !visited[next] {
            queue.append((next, current.cost + 1))
            visited[next] = true
        }
    }
}

var results = ""
minimumDistance.enumerated().forEach { city, cost in
    if cost == K, city != X {
        results += "\(city)\n"
    }
}
print(results.isEmpty ? "-1" : results)
