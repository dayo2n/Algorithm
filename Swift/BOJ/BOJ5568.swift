
// [출처: BOJ] https://www.acmicpc.net/problem/5568
// 백트래킹

let n = Int(readLine()!)!
let k = Int(readLine()!)!
var cards = [Int]()
for _ in 0..<n {
    cards.append(Int(readLine()!)!)
}

var visited = Array(repeating: false, count: n)
var results = Set<Int>()

func backracking(current: String, count: Int) {
    if count == k {
        results.insert(Int(current)!)
        return
    }
    
    for index in 0..<n {
        if !visited[index] {
            visited[index] = true
            backracking(current: current + cards[index].description, count: count + 1)
            visited[index] = false
        }
    }
}

for index in 0..<n {
    if !visited[index] {
        visited[index] = true
        backracking(current: cards[index].description, count: 1)
        visited[index] = false
    }
}

print(results.count)
