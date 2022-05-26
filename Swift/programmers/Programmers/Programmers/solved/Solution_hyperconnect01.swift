//
//  main.swift
//  Programmers
//
//  Created by 문다 on 2022/05/21.
//

import Foundation


func solution(_ people:[Int]) -> [Int] {
    
    var coupon : [Int : Int] = [:]
    var answer : [Int] = []
    
    for uid in people {
        if !coupon.keys.contains(uid) {
            coupon[uid] = 1
        } else {
            if coupon[uid]! < 3 {
                coupon[uid]! += 1
            } else {
                answer.append(uid)
                coupon[uid] = 1
            }
        }
    }
    
    if answer.count == 0 {
        return [-1]
    }
    
    return answer
}

print(solution([1,3,3,2,4,3,3,2,4,2,2,4]))
print(solution([1,1,3,3,3,3,1,3,3,3,3,2]))
print(solution([1,2,3,4]))
