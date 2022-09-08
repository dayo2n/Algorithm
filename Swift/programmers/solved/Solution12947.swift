//
//  main.swift
//  Programmers
//
//  Created by 문다 on 2022/05/21.
//
func solution(_ x:Int) -> Bool {
    return x % Array(String(x)).compactMap{Int(String($0))!}.reduce(0, +) == 0
}
