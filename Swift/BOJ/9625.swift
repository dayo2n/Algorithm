
// [출처: BOJ] https://www.acmicpc.net/problem/9625

let k: Int = Int(readLine()!)!

var a: Int = 1
var b: Int = 0

for _ in 0..<k {
    let tmp = b
    b += a
    a = tmp
}

print("\(a) \(b)")

