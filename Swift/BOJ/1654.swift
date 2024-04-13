
// [출처: BOJ] https://www.acmicpc.net/problem/1654

llet input = readLine()!.split(separator: " ").map { Int($0)! }
let (k, n) = (input[0], input[1])
var cables = [Int]()
for _ in 0..<k {
    cables.append(Int(readLine()!)!)
}

var (left, right) = (1, cables.max()!)
var maxLength = 0
while left <= right {
    let mid = (left + right) / 2
    
    let sumOfCables = cables.map { $0 / mid }.reduce(0, +)
    if sumOfCables >= n {
        maxLength = max(maxLength, mid)
        left = mid + 1
    } else {
        right = mid - 1
    }
}

print(maxLength)
