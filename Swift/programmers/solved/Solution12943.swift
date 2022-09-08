//
//  main.swift
//  Programmers
//
//  Created by 문다 on 2022/05/21.
//
func solution(_ num:Int) -> Int {
    guard num != 1 else { return 0 }
    
    var repeated: Int = 0
    var target = num
    
    while target != 1 {
        if repeated == 500 {
            return -1
        }
        
        if target % 2 == 0 {
            target = target / 2
        } else {
            target = target * 3 + 1
        }
    
        repeated = repeated + 1
    }
    return repeated
}
