
// [출처: BOJ] https://www.acmicpc.net/problem/1238

var input = readLine()!.split(separator: " ").map { Int($0)! }
let (n, m, x) = (input[0], input[1], input[2])

var routes = Array(repeating: [(to: Int, cost: Int)](), count: n + 1)
for _ in 0..<m {
    input = readLine()!.split(separator: " ").map { Int($0)! }
    routes[input[0]].append((to: input[1], cost: input[2]))
}

for number in 1...n {
    routes[number].sort(by: { $0.cost < $1.cost })
}

var go = Array(repeating: 0, count: n + 1)

for student in 1...n {
    var minCosts = Array(repeating: Int.max, count: n + 1)
    minCosts[student] = 0
    var queue = [student]

    while !queue.isEmpty {
        let currentBarn = queue.removeFirst()
        let currentCost = minCosts[currentBarn]
        
        for nextBarn in routes[currentBarn] {
            if minCosts[nextBarn.to] <= currentCost + nextBarn.cost { continue }
            minCosts[nextBarn.to] = currentCost + nextBarn.cost
            queue.append(nextBarn.to)
        }
    }
    go[student] = minCosts[x]
}

var backMinCosts = Array(repeating: Int.max, count: n + 1)
backMinCosts[0] = 0
backMinCosts[x] = 0
var queue = [x]

while !queue.isEmpty {
    let currentBarn = queue.removeFirst()
    let currentCost = backMinCosts[currentBarn]
    
    for nextBarn in routes[currentBarn] {
        if backMinCosts[nextBarn.to] <= currentCost + nextBarn.cost { continue }
        backMinCosts[nextBarn.to] = currentCost + nextBarn.cost
        queue.append(nextBarn.to)
    }
}

print(zip(go, backMinCosts).map { $0 + $1 }.max()!)
