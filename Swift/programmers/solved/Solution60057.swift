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


// 2. 딕셔너리를 쓰는 방법

func solution(_ record:[String]) -> [String] {
    
    var userList : [String : String] = [:]
    var answer : [String] = []
    
//    for data in record {
//
//        let line = data.split(separator: " ")
//
//        let cmd : String = String(line[0])
//        let uid : String = String(line[1])
//
//        switch (cmd) {
//        case "Enter" :
//            let nickname : String = String(line[2])
//            userList[uid] = nickname
//            break
//        case "Change":
//            let nickname : String = String(line[2])
//            userList[uid] = nickname
//            break
//        default:
//            break
//        }
//    }
//
//    for data in record {
//
//        let line = data.split(separator: " ")
//
//        let cmd : String = String(line[0])
//        let uid : String = String(line[1])
//
//        switch (cmd) {
//        case "Enter" :
//            answer.append("\(userList[uid]!)님이 들어왔습니다.")
//            break
//        case "Leave":
//            answer.append("\(userList[uid]!)님이 나갔습니다.")
//            break
//        default:
//            break
//        }
//    }
    
    record.forEach {
        let line = $0.components(separatedBy: " ")
        if line.count > 2 { // Enter 
             
        }
    }
    
    return answer
}

print(solution(["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]))
// ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]

// 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/60057
