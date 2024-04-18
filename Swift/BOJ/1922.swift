
// [출처: BOJ] https://www.acmicpc.net/problem/1922
/*
 최소 스패닝 트리: union & find
 */

let N = Int(readLine()!)! // #computer
let M = Int(readLine()!)! // #cable (enable to connect)

var costs = [Int](0...N)

var queue = [(from: Int, to: Int, cost: Int)]()
for _ in 0..<M {
    let input = readLine()!.split(separator: " ").map { Int($0)! }
    let (computerA, computerB, cost) = (input[0], input[1], input[2])
    if computerA != computerB {
        queue.append((computerA, computerB, cost))
    }
}

queue.sort(by: { $0.cost < $1.cost })
var total = 0
for element in queue {
    if findRoot(element.from) != findRoot(element.to) {
        union(element.from, element.to)
        total += element.cost
    }
}
print(total)

func union(_ a: Int, _ b: Int) {
    let rootA = findRoot(a), rootB = findRoot(b)
    if rootA != rootB {
        costs[rootB] = rootA
    }
}

func findRoot(_ x: Int) -> Int {
    if x == costs[x] {
        return x
    }
    costs[x] = findRoot(costs[x])
    return costs[x]
}
