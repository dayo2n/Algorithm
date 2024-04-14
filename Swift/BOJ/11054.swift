
// [출처: BOJ] https://www.acmicpc.net/problem/11054
let N = Int(readLine()!)!
let array = readLine()!.split(separator: " ").map { Int($0)! }
var LIS = [1]
var LDS = Array(repeating: 1, count: N)

for (index, number) in array.enumerated() {
    if index == 0 {
        continue
    }
    /* get LIS, LDS */
    var maxLIS = 1
    for prevIndex in 0..<index {
        if number > array[prevIndex] {
            maxLIS = max(maxLIS, LIS[prevIndex] + 1)
        }
    }
    LIS.append(maxLIS)
}

for (index, number) in array.reversed().enumerated() {
    if index == 0 { continue }
    /* get LDS */
    var maxLDS = 1
    for prevIndex in ((N-index-1)..<N).reversed() {
        if number > array[prevIndex] {
            maxLDS = max(maxLDS, LDS[prevIndex] + 1)
        }
    }
    LDS[N-index-1] = maxLDS
}

let bitonic = Array(zip(LIS, LDS).map { $0.0 + $0.1 })
print(bitonic.max()!-1)
/*
 LIS랑 LDS를 각각 구하고, 원소를 기준으로 이 두 값을 합한 값의 최댓값이 정답
 기본적으로 각각 값이 1로 세팅되어 있어 중복으로 더해지니 1 빼줌
 */
