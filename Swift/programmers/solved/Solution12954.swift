//
//  main.swift
//  Programmers
//
//  Created by 문다 on 2022/05/21.
//
func solution(_ x:Int, _ n:Int) -> [Int64] {
//    var answer: [Int64] = [Int64(x)]
//    for _ in (1..<n) {
//        answer.append(answer[answer.count - 1] + Int64(x))
//    }
//    return answer
    return Array(1...n).map{Int64($0 * x)}
}

// 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/12954
