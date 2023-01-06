
// [출처: BOJ] https://www.acmicpc.net/problem/15312

let count: [String: Int] = ["A": 3, "B": 2, "C": 1, "D": 2, "E": 3,
                            "F": 3, "G": 2, "H": 3, "I": 3, "J": 2,
                            "K": 2, "L": 1, "M": 2, "N": 2, "O": 1,
                            "P": 2, "Q": 2, "R": 2, "S": 1, "T": 2,
                            "U": 1, "V": 1, "W": 1, "X": 2, "Y": 2, "Z": 1]

var A: [Int] = Array(readLine()!).map({count[String($0)]!})
var B: [Int] = Array(readLine()!).map({count[String($0)]!})

var sum1: [Int] = []
var sum2: [Int] = []

while A.count > 1 {
    for index in 0..<min(A.count, B.count) {
        sum1.append((A[index] + B[index]) % 10)
        if index + 1 < A.count {
            sum2.append((B[index] + A[index + 1]) % 10)
        }
    }
    A = sum1
    B = sum2
    sum1.removeAll()
    sum2.removeAll()
}
print("\(A[0])\(B[0])")
