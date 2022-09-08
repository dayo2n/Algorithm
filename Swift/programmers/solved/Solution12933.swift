//
//  main.swift
//  Programmers
//
//  Created by 문다 on 2022/05/21.
//
func solution(_ n:Int64) -> Int64 {
    let reversedArray = Array(String(n)).compactMap{Int(String($0))}.sorted(by: >)
    return Int64(reversedArray.compactMap{String($0)}.reduce("", {return $0 + $1}))!
}
