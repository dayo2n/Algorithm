//
//  main.swift
//  Programmers
//
//  Created by 문다 on 2022/05/21.
//

import Foundation

func solution(_ maps:[[Int]]) -> Int{
    var answer = 0
    
    var row : Int = 0
    var col : Int = 0
    
    for map in maps {
        
        for data in map {
            
            if data == 1 {
                // 상하좌우를 확인해서 1이 있으면 -1씩
                // 상
                if row != 0 { // -1일수도
                    if maps[row - 1][col] == 0 {
                        answer += 1
                    }
                } else { // row == 0
                    answer += 1
                }
                
                // 하
                if row != (maps.count - 1) {
                    if maps[row + 1][col] == 0 {
                        answer += 1
                    }
                } else {
                    answer += 1
                }
                
                // 좌
                if col != 0 {
                    if maps[row][col - 1] == 0 {
                        answer += 1
                    }
                } else {
                    answer += 1
                }
                
                // 우
                if col != (map.count - 1) {
                    if maps[row][col + 1] == 0 {
                        answer += 1
                    }
                } else {
                    answer += 1
                }
                
            }
            
            col += 1
        }
        
        row += 1
        col = 0
    }
    
    return answer
}

print(solution([[0,0,1,0,0],[0,1,1,0,1],[0,0,1,0,1],[1,1,1,0,1]]))
print(solution([[1,0,1,1],[0,0,1,1],[1,1,0,1],[1,1,0,0]]))
