
// [출처: BOJ] https://www.acmicpc.net/problem/14502
// 브루트포스, BFS

import Foundation
var input = readLine()!.split(separator: " ").map { Int($0)! }
let (N ,M) = (input[0], input[1])

var lab = [[Int]]()
var virusQueue = [Position]()
for n in 0..<N {
    input = readLine()!.split(separator: " ").map{ Int($0)! }
    lab.append(input)
    for m in 0..<M {
        if input[m] == Area.virus.rawValue {
            virusQueue.append(Position(x: n, y: m))
        }
    }
}

enum Area: Int {
    case blank = 0
    case wall = 1
    case virus = 2
}

struct Position {
    let x: Int
    let y: Int
}

var maxSafeArea = 0
var installedWall = 0
let flatLab = lab.flatMap({$0})
for first in 0..<N*M-2 {
    if flatLab[first] == Area.blank.rawValue {
        lab[first / M][first % M] = Area.wall.rawValue
        for second in first+1..<N*M-1 {
            if flatLab[second] == Area.blank.rawValue {
                lab[second / M][second % M] = Area.wall.rawValue
                for third in second+1..<N*M {
                    if flatLab[third] == Area.blank.rawValue {
                        lab[third / M][third % M] = Area.wall.rawValue
                        maxSafeArea = max(maxSafeArea, spreadVirus(lab, virusQueue))
                        lab[third / M][third % M] = Area.blank.rawValue
                    }
                }
                lab[second / M][second % M] = Area.blank.rawValue
            }
        }
        lab[first / M][first % M] = Area.blank.rawValue
    }
}

func spreadVirus(_ lab: [[Int]], _ virusQueue: [Position]) -> Int {
    var currentLab = lab
    var queue = virusQueue
    while !queue.isEmpty {
        let position = queue.removeFirst()
        let dx = [-1, 1, 0, 0]
        let dy = [0, 0, -1, 1]
        for index in 0..<4 {
            let currentX = position.x + dx[index]
            let currentY = position.y + dy[index]
            if currentX > -1, currentX < N,
               currentY > -1, currentY < M {
                if currentLab[currentX][currentY] == 0 {
                    currentLab[currentX][currentY] = 2
                    queue.append(Position(x: currentX, y: currentY))
                }
            }
        }
    }
    let labIntoArray = currentLab.flatMap({$0})
    let countSafeArea = labIntoArray.filter {$0 == Area.blank.rawValue }.count
    return countSafeArea
}

print(maxSafeArea)
