
// [출처: BOJ] https://www.acmicpc.net/problem/10825

let N: Int = Int(readLine()!)!
var scores: [String: [Int]] = [:]

for _ in 0..<N {
    let score: [String] = readLine()!.split(separator: " ").map{String($0)}
    scores[score[0]] = [Int(score[1])!, Int(score[2])!, Int(score[3])!]
}

scores.sorted(by: { if $0.value[0] == $1.value[0] {
    if $0.value[1] == $1.value[1] {
        if $0.value[2] == $1.value[2] {
            return $0.key < $1.key
        } else { return $0.value[2] > $1.value[2] }
    } else { return $0.value[1] < $1.value[1] }
} else { return $0.value[0] > $1.value[0] }
}).map{ $0.key }.forEach { name in
    print(name)
}
