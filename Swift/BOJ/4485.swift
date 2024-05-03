
// [출처: BOJ] https://www.acmicpc.net/problem/4485

/*
 원래는 visited로 이미 방문한 곳을 다시 방문하는 경우는 최소 비용이 나오지 않을 것이라고 생각했는데,
 생각해보면 방문했던 곳을 다시 방문해야 하는 경우도 있음
 최소 비용인지만 확인해주면 다익스트라 + 그래프로 풀리는 문제
 */

var testcase = 1
while true {
    let caveSize = Int(readLine()!)!
    if caveSize == 0 { break }
    
    var caves = [[Int]]()
    for _ in 0..<caveSize {
        let input = readLine()!.split(separator: " ").map { Int($0)! }
        caves.append(input)
    }
    
    var minCosts = Array(repeating: Array(repeating: Int.max, count: caveSize), count: caveSize)
    minCosts[0][0] = caves[0][0]
    var queue = [(x: 0, y: 0, cost: minCosts[0][0])]
    let dx = [1, -1, 0, 0]
    let dy = [0, 0, -1, 1]
    while !queue.isEmpty {
        let current = queue.removeFirst()
        let (currentX, currentY, currentCost) = (current.x, current.y, current.cost)
        if minCosts[currentX][currentY] < currentCost { continue }
        
        for move in 0..<4 {
            let (nextX, nextY) = (currentX + dx[move], currentY + dy[move])
            if nextX < 0 || nextX >= caveSize || nextY < 0 || nextY >= caveSize { continue }
            if minCosts[nextX][nextY] <= minCosts[currentX][currentY] + caves[nextX][nextY] { continue }
            minCosts[nextX][nextY] = minCosts[currentX][currentY] + caves[nextX][nextY]
            queue.append((x: nextX, y: nextY, cost: minCosts[nextX][nextY]))
        }
    }
    print("Problem \(testcase): \(minCosts[caveSize-1][caveSize-1])")
    testcase += 1
}
