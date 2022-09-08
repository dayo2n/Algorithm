//
//  main.swift
//  Programmers
//
//  Created by 문다 on 2022/05/21.
//

import Foundation

func solution(_ n:Int) -> Int {
    
    if n == 0 {
        return 0
    } else if n == 1 {
        return 1
    }
    
    var x: Int = 2
    var answer: Int = 1
    
    while x <= n {
        if n % x == 0 {
            answer = answer + x
        }
        x = x + 1
    }
    return answer
}
