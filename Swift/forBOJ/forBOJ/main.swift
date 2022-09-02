//
//  main.swift
//  forBOJ
//
//  Created by 문다 on 2022/01/13.
//

//import Foundation

var input = Int(readLine()!)!

for idx in (0..<input) {
    for _ in (0..<idx).reversed() {
        print(" ", terminator: "")
    }
    for _ in 0...idx {
        print("*", terminator: "")
    }
    print("")
}
