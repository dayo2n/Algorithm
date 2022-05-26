//
//  main.swift
//  Programmers
//
//  Created by 문다 on 2022/05/21.
//

import Foundation


func solution(_ p:[String]) -> Int64 {
    
    var results : [Int] = []
    var operands : [Int] = []
    
    for q in p {
        if q == "+" || q == "-" || q == "*" || q == "/" {
            
            var op1 : Int
            var op2 : Int
            
            var result : Int = 0
            
            if operands.count == 0 { // 없으면 results 두 요소를 이용
                op1 = results[results.count - 1]
                results.removeLast()
                op2 = results[results.count - 1]
                results.removeLast()
            } else if operands.count == 1 { // 하나이면 results와 계산
                op1 = operands[operands.count - 1]
                op2 = results[results.count - 1]
                results.removeLast()
                operands.removeLast()
            } else { // 두 개 이상인 경우는 스택에서 두개 꺼내서 쓰고
                op1 = operands[operands.count - 1]
                operands.removeLast()
                op2 = operands[operands.count - 1]
                operands.removeLast()
            }
            
            switch (q) {
            case "+":
                result = op2 + op1
                break
            case "-":
                result = op2 - op1
                break
            case "*":
                result = op2 * op1
                break
            case "/":
                result = op2 / op1
                break
            default:
                break
            }
            results.append(result)
        }
        else {
            operands.append(Int(q)!)
            print(q)
        }
    }
    return Int64(results[0])
}

print(solution(["12","2","5","+","*","9","3","/","-"]))
print("")
print(solution(["1","1","+","1","1","+","*"]))
