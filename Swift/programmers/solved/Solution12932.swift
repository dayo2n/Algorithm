//
//  main.swift
//  Programmers
//
//  Created by 문다 on 2022/05/21.
//
func solution(_ n:Int64) -> [Int] {
//    return Array(String(n).reversed()).map{ Int(String($0))! }
    return Array(String(n).reversed()).compactMap{ Int(String($0)) }
}

// 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/12932
