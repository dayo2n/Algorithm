//
//  main.swift
//  Programmers
//
//  Created by 문다 on 2022/05/21.
//

import Foundation

func solution(_ numbers:[Int]) -> String {
    
    let num : [Int] = numbers.sorted { Int("\($0)\($1)")! > Int("\($1)\($0)")! }
    
    // 첫번째 요소부터 0이라면 전부 0이므로
    if num[0] == 0 {
        return "0"
    }
    
//    var answer : String = ""
//
//    for n in num {
//        answer += String(n)
//    }
//
//    return answer
    
    return num.reduce("") { $0 + "\($1)"}
}

print(solution([6, 10, 2]))
print(solution([3, 30, 34, 5, 9]))

// 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/42746
