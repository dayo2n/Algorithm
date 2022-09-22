//
//  main.swift
//  commandLineTool
//
//  Created by 문다 on 2022/09/02.
//

import Foundation

func solution(_ survey:[String], _ choices:[Int]) -> String {
    
    var mbti: [Character: Int] = ["T" : 0, "R" : 0,
                                  "C" : 0, "F" : 0,
                                  "J" : 0, "M" : 0,
                                  "A" : 0, "N" : 0]
    
    for (idx, question) in survey.enumerated() {
        let low = question[question.startIndex]
        let high = question[question.index(before: question.endIndex)]
        switch choices[idx] {
        case 1:
            mbti[low] = mbti[low]! + 3
        case 2:
            mbti[low] = mbti[low]! + 2
        case 3:
            mbti[low] = mbti[low]! + 1
        case 5:
            mbti[high] = mbti[high]! + 1
        case 6:
            mbti[high] = mbti[high]! + 2
        case 7:
            mbti[high] = mbti[high]! + 3
        default: break // 4
        }
    }
    
    var ret = ""
    ret += (mbti["R"]! >= mbti["T"]!) ? "R" : "T"
    ret += (mbti["C"]! >= mbti["F"]!) ? "C" : "F"
    ret += (mbti["J"]! >= mbti["M"]!) ? "J" : "M"
    ret += (mbti["A"]! >= mbti["N"]!) ? "A" : "N"
    print(ret)
    
    return ret
}

// 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/18666
