//
//  main.swift
//  Programmers
//
//  Created by 문다 on 2022/05/21.
//
import Foundation

func solution(_ n:Int) -> Int
{
    var answer:Int = 0
    
    String(n).enumerated().forEach {
        answer = answer + Int(String($0.element))!
    }
    
    return answer
}
