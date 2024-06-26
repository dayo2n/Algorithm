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
