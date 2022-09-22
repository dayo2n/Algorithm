//
//  main.swift
//  Programmers
//
//  Created by 문다 on 2022/05/21.
//
func solution(_ n:Int64) -> Int64 {
//    let reversedArray = Array(String(n)).compactMap{Int(String($0))}.sorted(by: >)
//    return Int64(reversedArray.compactMap{String($0)}.reduce("", {return $0 + $1}))!
    return Int64(String(String(n).sorted(by: >)))!
    // 정수형 배열로 변환하지않고 string 상태에서 정렬하면 된다 .......
}

// 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/12933
