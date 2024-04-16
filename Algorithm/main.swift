let input = readLine()!.split(separator: " ").map { Int($0)! }
let totalDot = input[0]
let totalRound = input[1]
var parent = [Int](0..<totalDot)

func findRoot(_ child: Int) -> Int {
    if parent[child] == child {
        return child
    }
    
    parent[child] = findRoot(parent[child])
    return parent[child]
}

func union(_ first: Int, _ second: Int) {
    let parentFirst = findRoot(first), parentSecond = findRoot(second)
    
    if parentFirst < parentSecond {
        parent[parentSecond] = parentFirst
    } else {
        parent[parentFirst] = parentSecond
    }
}

for round in 0..<totalRound {
    let dots = readLine()!.split(separator: " ").map { Int($0)! }
    let first = dots[0], second = dots[1]
    
    if findRoot(first) == findRoot(second) {
        print(round + 1)
        break
    }
    
    union(first, second)
    
    if round == totalRound - 1 {
        print(0)
    }
}
