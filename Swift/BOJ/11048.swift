
// [출처: BOJ] https://www.acmicpc.net/problem/11048


var input: [Int] = readLine()!.split(separator: " ").map({ Int($0)! })
let (N, M) = (input[0], input[1])

var maze: [[Int]] = Array(repeating: Array(), count: N)

for row in 0..<N {
    maze[row] = readLine()!.split(separator: " ").map({ Int($0)! })
}

for n in 0..<N {
    for m in 0..<M {
        if n == 0 && m == 0 { continue }
        if n == 0 {
            maze[n][m] += maze[n][m-1]
        } else if m == 0 {
            maze[n][m] += maze[n-1][m]
        } else {
            maze[n][m] += max(maze[n-1][m], maze[n][m-1])
        }
    }
}

print(maze[N-1][M-1])
