
// [출처: BOJ] https://www.acmicpc.net/problem/30679
/*
 시뮬레이션
 모든 열을 다 도는 줄 알고 잠깐 헤맸는데 모든 행 첫 번째 열에 대해서만 시뮬레이션 돌리는 문제
 */

let input = readLine()!.split(separator: " ").map { Int($0)! }
let (n, m) = (input[0], input[1])

var board = [[Int]]()
for _ in 0..<n {
    board.append(readLine()!.split(separator: " ").map { Int($0)! })
}

enum StarDirection: Int {
    case right = 0
    case bottom = 90
    case left = 180
    case top = 270
}

var enableCases = 0
var enableRows = [Int]()
for row in 0..<n {
    var (x, y) = (row, 0)
    var directionDegree = 0
    var visited = Array(repeating: Array(repeating: [], count: m), count: n)
    while true {
        let currentDirect = StarDirection(rawValue: directionDegree % 360)!
        if !visited[x][y].isEmpty, visited[x][y].contains(where: { $0 as! StarDirection == currentDirect }) {
            enableCases += 1
            enableRows.append(row + 1)
            break
        }
        visited[x][y].append(currentDirect)
        
        switch currentDirect {
        case .right:
            y += board[x][y]
        case .left:
            y -= board[x][y]
        case .bottom:
            x += board[x][y]
        case .top:
            x -= board[x][y]
        }
        
        directionDegree += 90
        
        if x < 0 || x >= n || y < 0 || y >= m { break }
    }
}

print(enableCases)
enableRows.forEach {
    print($0, terminator: " ")
}
