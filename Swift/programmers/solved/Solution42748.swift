//
//  main.swift
//  Programmers
//
//  Created by 문다 on 2022/05/21.
//

import Foundation

func solution(_ array:[Int], _ commands:[[Int]]) -> [Int] {
    
    var answer : [Int] = []
    
    for cmd in commands {
        let i = cmd[0]
        let j = cmd[1]
        let k = cmd[2]
        var newArr = array[i-1..<j]
        answer.append(newArr.sorted()[k-1])
    }
    
    return answer
}

print(solution([1, 5, 2, 6, 3, 7, 4], [[2, 5, 3], [4, 4, 1], [1, 7, 3]]))
