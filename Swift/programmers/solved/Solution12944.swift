//
//  main.swift
//  Programmers
//
//  Created by 문다 on 2022/05/21.
//
func solution(_ arr:[Int]) -> Double {
    return Double(arr.reduce(0,+)) / Double(arr.count)
    // ! runtime error : reduce(0, +) // space
}

// 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/12944
