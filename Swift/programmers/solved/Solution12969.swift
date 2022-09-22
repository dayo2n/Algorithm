import Foundation

let n = readLine()!.components(separatedBy: [" "]).map { Int($0)! }
let (a, b) = (n[0], n[1])

print(String(repeating: "\(String(repeating: "*", count: a))\n", count: b))

// 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/12969
