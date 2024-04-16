
// [출처: BOJ] https://www.acmicpc.net/problem/12850
/*
인접행렬의 곱, 분할 정복을 이용한 거듭제곱
 */

let minute = Int(readLine()!)!
let MOD = 1_000_000_007

let matrix = [
    [0, 1, 1, 0, 0, 0, 0, 0],
    [1, 0, 1, 1, 0, 0, 0, 0],
    [1, 1, 0, 1, 0, 1, 0, 0],
    [0, 1, 1, 0, 1, 1, 0, 0],
    [0, 0, 0, 1, 0, 1, 1, 0],
    [0, 0, 1, 1, 1, 0, 0, 1],
    [0, 0, 0, 0, 1, 0, 0, 1],
    [0, 0, 0, 0, 0, 1, 1, 0]
]

func multiply(a: [[Int]], b: [[Int]]) -> [[Int]] {
    var results = Array(repeating: Array(repeating: 0, count: 8), count: 8)
    for idx1 in 0..<8 {
        for idx2 in 0..<8 {
            for idx3 in 0..<8 {
                results[idx1][idx2] = (results[idx1][idx2] + a[idx1][idx3] * b[idx3][idx2]) % MOD
            }
        }
    }
    return results
}

func divideAndConquer(pow: Int) -> [[Int]] {
    if pow == 1 {
        return matrix
    }
    
    var results = divideAndConquer(pow: pow / 2)
    results = multiply(a: results, b: results)
    if pow % 2 == 1 {
        results = multiply(a: results, b: matrix)
    }
    return results
}

let afterWalk = divideAndConquer(pow: minute)
print(afterWalk[0][0])
