
// [출처: BOJ] https://www.acmicpc.net/problem/5972

var input = readLine()!.split(separator: " ").map { Int($0)! }
let (n, m) = (input[0], input[1])

var routes = Array(repeating: [(to: Int, cost: Int)](), count: n + 1)
for _ in 0..<m {
    input = readLine()!.split(separator: " ").map { Int($0)! }
    routes[input[0]].append((to: input[1], cost: input[2]))
    routes[input[1]].append((to: input[0], cost: input[2]))
}

for number in 1...n {
    routes[number].sort(by: { $0.cost < $1.cost })
}

var minCosts = Array(repeating: Int.max, count: n + 1)
minCosts[1] = 0
var queue = [1]

while !queue.isEmpty {
    let currentBarn = queue.removeFirst()
    let currentCost = minCosts[currentBarn]
    
    for nextBarn in routes[currentBarn] {
        if minCosts[nextBarn.to] <= currentCost + nextBarn.cost { continue }
        minCosts[nextBarn.to] = currentCost + nextBarn.cost
        queue.append(nextBarn.to)
    }
}

print(minCosts[n])
