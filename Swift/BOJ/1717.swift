
// [출처: BOJ] https://www.acmicpc.net/problem/1717
/*
분리집합 union&find
 */

let input = readLine()!.split(separator: " ").map { Int($0)! }
let n = input[0]
let m = input[1]
var parent = [Int](0..<n+1)

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

for _ in 0..<m {
    let input = readLine()!.split(separator: " ").map { Int($0)! }
    let command = input[0], first = input[1], second = input[2]
    if command == 1 {
        print(findRoot(first) == findRoot(second) ? "YES" : "NO")
    } else {
        union(first, second)
    }
}
