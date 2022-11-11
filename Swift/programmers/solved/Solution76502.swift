// [출처: 프로그래머스] https://school.programmers.co.kr/learn/courses/30/lessons/76502


import Foundation

let pairOfBracket: [String: String] = [")": "(", "]": "[", "}": "{"]

func checkBracket(_ s: String) -> Bool {
    var openBracket: [String] = []
    for bracket in s {
        if String(bracket) == "(" || String(bracket) == "[" || String(bracket) == "{" {
            openBracket.append(String(bracket))
        } else {
            if !openBracket.isEmpty {
                if openBracket.last! != pairOfBracket[String(bracket)] { return false }
                else { openBracket.removeLast() }
            } else { return false }
        }
    }
    return openBracket.isEmpty ? true : false
}

func solution(_ s:String) -> Int {
    var count: Int = 0
    for rotation in 0..<s.count {
        let rotatedString: String = String(s.suffix(from: s.index(s.startIndex, offsetBy: rotation))) + String(s.prefix(upTo: s.index(s.startIndex, offsetBy: rotation)))
        if checkBracket(rotatedString) {count += 1}
    }
    return count
}
