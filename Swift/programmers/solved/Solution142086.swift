// [출처: 프로그래머스] https://school.programmers.co.kr/learn/courses/30/lessons/142086

import Foundation

func solution(_ s:String) -> [Int] {
    var distance: [String: Int] = ["a": -1, "b": -1, "c": -1, "d": -1, "e": -1,
                                  "f": -1, "g": -1, "h": -1, "i": -1, "j": -1,
                                  "k": -1, "l": -1, "m": -1, "n": -1, "o": -1,
                                  "p": -1, "q": -1, "r": -1, "s": -1, "t": -1,
                                  "u": -1, "v": -1, "w": -1, "x": -1, "y": -1, "z": -1]
    var answer: [Int] = []
    for (index, word) in s.enumerated() {
        if distance[String(word)]! == -1 { answer.append(-1) }
        else { answer.append(index - distance[String(word)]!) }
        distance[String(word)]! = index
    }
    
    return answer
}
