//
//  main.swift
//  Programmers
//
//  Created by 문다 on 2022/05/21.
//

import Foundation

func solution(_ absolutes:[Int], _ signs:[Bool]) -> Int {
    
    var result: Int = 0
    for (idx, absolute) in absolutes.enumerated() {
//        var number = signs[idx] ? absolute : -absolute
//        result = result + number
        result = result + (signs[idx] ? absolute : -absolute)
    }
    return result
}

// 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/76501
