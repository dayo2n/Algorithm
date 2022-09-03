//
//  main.swift
//  Programmers
//
//  Created by 문다 on 2022/05/21.
//

import Foundation
func solution(_ s:String) -> String {
    let numbers = s.split(separator: " ").map( { return Int($0)!} )
    return "\(numbers.min()!) \(numbers.max()!)"
}
