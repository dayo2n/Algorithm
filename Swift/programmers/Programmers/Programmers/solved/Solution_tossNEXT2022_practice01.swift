//
//  main.swift
//  Programmers
//
//  Created by 문다 on 2022/05/21.
//

import Foundation

func solution(_ n:Int, _ keyInputs:[Int]) -> String {
    print(n)
    print(keyInputs)
    var answer = ""
    
    for input in keyInputs {
        if input >= 0 {
            if answer.count < n { // n보다 길거나 작은 경우는 무시
                answer.append("\(input)") // answer += input
            }
        } else {
            if answer.count > 0 {
                if input == -2 { // clear
                    answer = ""
                } else { // back
                    var endRange = answer.index(answer.endIndex, offsetBy: -1)
                    answer = "\(answer[..<endRange])"
                }
            }
        }
    }
    
    if answer.count < n {
        return ""
    }

    return answer
}
