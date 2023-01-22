
// [출처: BOJ] https://www.acmicpc.net/problem/10819


let N: Int = Int(readLine()!)!
let inputArray: [Int] = readLine()!.split(separator: " ").map({Int($0)!})

func permutation(_ array: [Int], _ n: Int) -> [[Int]] {
    var result = [[Int]]()
    if array.count < n { return result }

    var stack: [([Int], [Bool])] = array.enumerated().map {
        var visited = Array(repeating: false, count: array.count)
        visited[$0.offset] = true
        return ([$0.element], visited)
    }
    
    while stack.count > 0 {
        let now = stack.removeLast()
        
        let elements = now.0
        var visited = now.1
        
        if elements.count == n {
            result.append(elements)
            continue
        }
        
        for i in 0...array.count-1 {
            if visited[i] { continue }
            visited[i] = true
            stack.append((elements + [array[i]], visited))
            visited[i] = false
        }
    }
    
    return result
}

var answer = 0
let targets: [[Int]] = permutation(inputArray, N)

for target in targets {
    var sum = 0
    for i in 0..<N-1 {
        sum += abs(target[i] - target[i+1])
    }
    answer = max(sum, answer)
}
            
print(answer)
