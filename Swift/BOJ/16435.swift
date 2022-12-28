
// [출처: BOJ] https://www.acmicpc.net/problem/16435

var input: [Int] = readLine()!.split(separator: " ").map{Int($0)!}
let N: Int = input[0]
var L: Int = input[1]

var fruit: [Int] = []
input = readLine()!.split(separator: " ").map{Int($0)!}
for h in 0..<N {
    fruit.append(input[h])
}

input = input.sorted()

for h in 0..<N {
    if input[h] > L { break }
    L += 1
}

print(L)
