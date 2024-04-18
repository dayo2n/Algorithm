
// [출처: BOJ] https://www.acmicpc.net/problem/1389
/*
 DFS
 앞서 푼 경로찾기랑 거의 유사한 문제였따
 실버1치고 쉬운듯
 */

var input = readLine()!.split(separator: " ").map { Int($0)! }
let (N, M) = (input[0], input[1])

var friends = Array(repeating: Array(repeating: 0, count: N + 1), count: N + 1)
for _ in 0..<M {
    input = readLine()!.split(separator: " ").map { Int($0)! }
    let (left, right) = (input[0], input[1])
    friends[left][right] = 1
    friends[right][left] = 1
}

var (minKevinBacon, minKevinBaconFriend) = (Int.max, 0)
for left in 1..<N+1 {
    var kevinBacon = 0
    for right in 1..<N+1 {
        kevinBacon += dfs(left, right)
    }
    if minKevinBacon > kevinBacon {
        minKevinBacon = kevinBacon
        minKevinBaconFriend = left
    }
}

print(minKevinBaconFriend)


func dfs(_ start: Int, _ end: Int) -> Int {
    var queue = [(friend: Int, count: Int)]()
    var visited = Array(repeating: Array(repeating: false, count: N + 1), count: N + 1)
    var bacon = Int.max
    queue.append((start, 0))
    while !queue.isEmpty {
        let first = queue.removeFirst()
        if first.friend == end {
            bacon = min(bacon, first.count + 1)
        }
        friends[first.friend].enumerated().forEach {
            if $1 == 1 {
                if !visited[first.friend][$0] {
                    queue.append(($0, first.count + 1))
                    visited[first.friend][$0] = true
                }
            }
        }
    }
    return bacon
}
