
// [출처: BOJ] https://www.acmicpc.net/problem/9328
/*
BFS
 */

import Foundation
enum PositionType: String {
    /*
     '.': 빈 공간
     '*': 벽, 상근이는 벽을 통과할 수 없음
     '$': 상근이가 훔쳐야하는 문서
     알파벳 대문자: 문
     알파벳 소문자: 열쇠, 그 문자의 대문자인 모든 문을 열 수 있음
     */
    case empty = "."
    case wall = "*"
    case doc = "$"
}

let testcase = Int(readLine()!)! // limit: 100 미만
for _ in 0..<testcase {
    let input = readLine()!.split(separator: " ").map { Int($0)! }
    let (height, width) = (input[0], input[1])
    var map = [[String]]()
    var queue = [(row: Int, col: Int)]()
    for _ in 0..<height {
        map.append(Array(readLine()!).map { String($0) })
    }
    var keys = Array(readLine()!).map{String($0)}
    var notYetVisitedDoors = Array(repeating: Array(repeating: "", count: width), count: height)
    let entries = [PositionType.empty.rawValue, PositionType.doc.rawValue]
    for row in 0..<height {
        if row == 0 || row == height - 1 {
            for col in 0..<width {
                if entries.contains(map[row][col])  {
                    queue.append((row, col))
                } else if Character(map[row][col]).isLowercase {
                    keys.append(map[row][col])
                    queue.append((row, col))
                } else if Character(map[row][col]).isUppercase {
                    notYetVisitedDoors[row][col] = map[row][col]
                }
            }
        } else {
            if let first = map[row].first {
                if entries.contains(first) {
                    queue.append((row, 0))
                } else if Character(map[row][0]).isLowercase {
                    keys.append(map[row][0])
                    queue.append((row, 0))
                } else if Character(map[row][0]).isUppercase {
                    notYetVisitedDoors[row][0] = map[row][0]
                }
            }
            if let last = map[row].last, entries.contains(last) {
                queue.append((row, width - 1))
            } else if Character(map[row][width - 1]).isLowercase {
                keys.append(map[row][width - 1])
                queue.append((row, width - 1))
            } else if Character(map[row][width - 1]).isUppercase {
                notYetVisitedDoors[row][width - 1] = map[row][width - 1]
            }
        }
    }
    
    var stolen = 0
    let dx = [-1, 1, 0, 0]
    let dy = [0, 0, -1, 1]
    var visited = Array(repeating: Array(repeating: false, count: width), count: height)

    while true {
        if queue.isEmpty {
            if notYetVisitedDoors.flatMap({ $0 }).filter({ !$0.isEmpty }).count == 0 { break }
            else {
                for row in 0..<height {
                    for col in 0..<width {
                        let char = notYetVisitedDoors[row][col]
                        if !char.isEmpty, keys.contains(char.lowercased()) {
                            queue.append((row, col))
                            notYetVisitedDoors[row][col] = ""
                        }
                    }
                }
                if queue.isEmpty { break }
            }
        }
        let position = queue.removeFirst()
        if visited[position.row][position.col] { continue }
        visited[position.row][position.col] = true
        notYetVisitedDoors[position.row][position.col] = ""
        if map[position.row][position.col] == PositionType.doc.rawValue { stolen += 1 }
        
        for move in 0..<4 {
            let nextX = position.row + dx[move]
            let nextY = position.col + dy[move]
            if nextX < 0 || nextX >= height || nextY < 0 || nextY >= width || visited[nextX][nextY] { continue }
            
            let rawValue = map[nextX][nextY]
            let type = PositionType(rawValue: rawValue)
            if type == .empty || type == .doc {
                queue.append((nextX, nextY))
            } else if type == .wall {
                continue
            } else {
                let char = Character(rawValue)
                if char.isUppercase { /* door */
                    if keys.contains(rawValue.lowercased()) {
                        queue.append((nextX, nextY))
                    } else {
                        notYetVisitedDoors[nextX][nextY] = rawValue
                    }
                } else if char.isLowercase { /* key */
                    keys.append(rawValue)
                    queue.append((nextX, nextY))
                    for row in 0..<height {
                        for col in 0..<width {
                            let door = notYetVisitedDoors[row][col]
                            if !door.isEmpty, door.lowercased() == rawValue {
                                queue.append((row, col))
                                notYetVisitedDoors[row][col] = ""
                            }
                        }
                    }
                }
            }
        }
    }
    
    print(stolen)
}
