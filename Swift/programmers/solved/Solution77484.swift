//
//  main.swift
//  Programmers
//
//  Created by 문다 on 2022/05/21.
//

import Foundation

//print("Hello, World!")

//var input = readLine()
//
//if let input = input {
//    print("input : \(input)")
//}


// Reading an Int
//var inputInt = Int(readLine()!)!
//print(inputInt)

func solution(_ lottos:[Int], _ win_nums:[Int]) -> [Int] {
    
//    var chkNumbers : [Bool] = Array(repeating: false, count: 46) // 0 ~ 45
//    var cntZero : Int = 0
//    var win : Int = 0
//
//    for lotto in lottos {
//        if lotto == 0 {
//            cntZero += 1
//        } else { // lotto != 0
//            chkNumbers[lotto].toggle()
//            if win_nums.contains(lotto) {
//                win += 1
//            }
//        }
//    }
//
//    let rank : [Int] = [6, 6, 5, 4, 3, 2, 1]
//    return [rank[win + cntZero], rank[win]]
    
    let cntZero = lottos.filter{$0 == 0}.count
    let win : Int = win_nums.filter { lottos.contains($0) }.count
    
    let rank : [Int] = [6, 6, 5, 4, 3, 2, 1]
    
    return [rank[win + cntZero], rank[win]]
}

print(solution([44, 1, 0, 0, 31, 25], [31, 10, 45, 1, 6, 19])) // [3, 5]
print(solution([0, 0, 0, 0, 0, 0], [38, 19, 20, 40, 15, 25])) // [1, 6]
print(solution([45, 4, 35, 20, 3, 9], [20, 9, 3, 45, 4, 35])) // [1, 1]
