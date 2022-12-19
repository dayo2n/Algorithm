
// [출처: BOJ] https://www.acmicpc.net/problem/5800


import Foundation

let K: Int = Int(readLine()!)!

for k in 1...K {
    print("Class \(k)")
    let input: [Int] = readLine()!.split(separator: " ").map{Int($0)!}
    let N: Int = input[0]
    var scores: [Int] = []
    for n in 1...N {
        scores.append(input[n])
    }
    scores = scores.sorted()
    var gap: Int = 0
    for (index, score) in scores.enumerated() {
        if index == (N-1) { continue }
        let tmp: Int = scores[index+1] - score
        if tmp > gap { gap = tmp }
    }
    print("Max \(scores[N-1]), Min \(scores[0]), Largest gap \(gap)")
}
