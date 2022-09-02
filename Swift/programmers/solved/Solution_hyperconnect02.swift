//
//  main.swift
//  Programmers
//
//  Created by 문다 on 2022/05/21.
//

import Foundation


func solution(_ n:Int) -> String
{
    
    var fibonacci: [Int] = [0, 1]
    
    for i in (2...70) {
        fibonacci.append(fibonacci[i-1] + fibonacci[i-2])
    }
    
    var ans:String = ""
    
    if n < 0 {
        if n % 2 == 0 { // 짝수일때 음수
            ans = "-\(fibonacci[-n])"
        } else { // 홀수일때 양수
            ans = String(fibonacci[-n])
        }
    }
    else { // n이 0이상
        ans = String(fibonacci[n])
    }
    return ans
}


print(solution(1))
print(solution(-1))
print(solution(-3))
