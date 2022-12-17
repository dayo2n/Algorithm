import Foundation

let input: [Int] = readLine()!.split(separator: " ").map{Int($0)!}
let N: Int = input[0]
let M: Int = input[1]

var array: [[Int]] = []
let dp: [[Int]] = Array(repeating: Array(repeating: 0, count: M + 1), count: N + 1)

// 배열채우기
for _ in 0..<N {
    let arr: String = readLine()!
    array.append(arr.split(separator: " ").map{Int($0)!})
}

for i in 1...N {
    for j in 1...M {
        dp[i][j] = array[i-1][j-1] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1]
    }
}

// 합 구하기
let K: Int = Int(readLine()!)!
for _ in 0..<K {
    let quiz: [Int] = readLine()!.split(separator: " ").map{Int($0)!}
    // [i, j, x, y]
    let (i, j, x, y) = (quiz[0], quiz[1], quiz[2], quiz[3])
    print(dp[x][y] - dp[x][j-1] - dp[i-1][y] + dp[i-1][j-1])
}
