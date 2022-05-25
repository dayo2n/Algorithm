//
//  main.swift
//  Programmers
//
//  Created by 문다 on 2022/05/21.
//

import Foundation

func solution(_ numbers:[Int], _ target:Int) -> Int {
    
    var count : Int = 0
    
    func DFS(index: Int, sum: Int) {
        
        if index == numbers.count - 1 && sum == target {
            count += 1
            return
        }
        
        guard index + 1 < numbers.count else { return }
        
        DFS(index: index + 1, sum: sum + numbers[index + 1])
        DFS(index: index + 1, sum: sum - numbers[index + 1])
    }
    
    DFS(index: -1, sum: 0)
    
    return count
}

print(solution([1, 1, 1, 1, 1], 3))
print(solution([4, 1, 2, 1], 4))
