//
//  main.swift
//  Programmers
//
//  Created by 문다 on 2022/05/21.
//
import Foundation

func solution(_ n:Int) -> Int {
    
    var x = 2
    while n % x != 1 {
        x = x + 1
    }
    return x
}

// 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/87389
