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

func solution(_ id_list:[String], _ report:[String], _ k:Int) -> [Int] {
    
    // 기신고 유저를 재신고하는 경우는 카운트되지 않도록 확인하기 위한 플래그 배열
    var reportedFlag : [[Bool]] = Array(repeating: Array(repeating: true, count: id_list.count), count: id_list.count)
    
    var reportedCount : [Int] = Array(repeating: 0, count: id_list.count) // 각 유저가 신고당한 횟수
    var getEmailCount : [Int] = Array(repeating: 0, count: id_list.count) // 신고한 유저가 정지먹은 결과를 받는 횟수
    
    for contents in report {
            let reportsID = id_list.firstIndex(of: String(contents.split(separator: " ")[0]))!
            let reportedID = id_list.firstIndex(of: String(contents.split(separator: " ")[1]))!
        
        if reportedFlag[reportsID][reportedID] {
            reportedCount[reportedID] += 1
            reportedFlag[reportsID][reportedID].toggle()
        }
    }
    
    reportedFlag = Array(repeating: Array(repeating: true, count: id_list.count), count: id_list.count)
    
    for contents in report {
        
        let reportsID = id_list.firstIndex(of: String(contents.split(separator: " ")[0]))!
        let reportedID = id_list.firstIndex(of: String(contents.split(separator: " ")[1]))!
        
        if reportedFlag[reportsID][reportedID] && reportedCount[reportedID] >= k {
            getEmailCount[reportsID] += 1
            reportedFlag[reportsID][reportedID].toggle()
        }
    }
    
    return getEmailCount
}


print(solution(["muzi", "frodo", "apeach", "neo"], ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"], 2))
//print(solution(["con", "ryan"], ["ryan con", "ryan con", "ryan con", "ryan con"], 3))
