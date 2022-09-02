//
//  main.swift
//  Programmers
//
//  Created by 문다 on 2022/05/21.
//

import Foundation

func solution(_ s:String) -> Int {
//    let alphabet : [String : String] = ["zero" : "0", "one" : "1", "two" : "2", "three" : "3", "four" : "4", "five" : "5", "six" : "6", "seven" : "7",  "eight" : "8", "nine" : "9"]
//    var answer : String = ""
//    var number : String = ""
//
//    for char in s {
//        if char.isNumber {
//            answer.append(char)
//            number = ""
//        } else {
//            number.append(char)
//            if alphabet.keys.contains(number) {
//                answer.append(alphabet[number]!)
//                number = ""
//            }
//        }
//    }
    let alphabet : [String] = ["zero", "one", "two", "three", "four", "five", "six", "seven",  "eight", "nine"]
    var answer : String = s
    
    for i in 0..<alphabet.count {
        answer = answer.replacingOccurrences(of: alphabet[i], with: String(i))
    }
    return Int(answer)!
}

print(solution("one4seveneight"))
print(solution("23four5six7"))
print(solution("2three45sixseven"))
print(solution("123"))
