//
//  main.swift
//  Programmers
//
//  Created by 문다 on 2022/05/21.
//

import Foundation

// timestamp format: yyyy-MM-dd'T'HH:mm:ss
func getTimestamp(_ timestamp: String) -> [String: String] {
    var retTimestamp = [String: String]()
    
    var splitByT = timestamp.split(separator: "T")
    retTimestamp["date"] = "\(splitByT[0])"
    
    var time = "\(splitByT[1])"
    retTimestamp["time"] = "\(time[..<time.index(time.endIndex, offsetBy: -3)])"

    return retTimestamp
}

func solution(_ messages:[[String]]) -> [String] {
    var prevUser = messages[0][1]
    var prevTime = getTimestamp(messages[0][0])["time"]
    var prevDate = getTimestamp(messages[0][0])["date"]
    
    var chats = [String]()
    chats.append("[\(prevUser)]")
    
    for message in messages {
        
        let curTimestamp = getTimestamp(message[0])
        if prevUser != message[1] {
            chats.append("(\(prevTime!))")
            if prevDate != curTimestamp["date"] {
                chats.append("-- \(curTimestamp["date"]!) --")
                prevDate = curTimestamp["date"]
            }
            chats.append("[\(message[1])]")
            prevUser = message[1]
            if prevTime != curTimestamp["time"] {
                prevTime = curTimestamp["time"]!
            }
        } else { // 같은 작성자이더라도
            if prevTime != curTimestamp["time"] { // 시간이 바뀌면 다시 묶어줌
                chats.append("(\(prevTime!))")
                prevTime = curTimestamp["time"]!
                
                if prevDate != curTimestamp["date"] {
                    chats.append("-- \(curTimestamp["date"]!) --")
                    prevDate = curTimestamp["date"]
                }
                
                chats.append("[\(message[1])]")
            }
        }
        
        if message[2].isEmpty { // == ""
            chats.append("<삭제된 메시지>")
        } else {
            chats.append(message[2])
        }
        
    }
    
    chats.append("(\(prevTime!))")
    
    for chat in chats{
        print(chat)
    }
    
    return chats
}

solution(
    [["2022-06-24T23:57:42", "정원", "민탁님"],
     ["2022-06-24T23:57:44", "정원", "생일이 얼마 안남으셨네요"],
     ["2022-06-24T23:57:54", "정원", "소감 한말씀 부탁드립니닼ㅋㅋㅋ"],
     ["2022-06-24T23:58:02", "금상", "오~ 민탁님 내일 생일이세요? 축하해요!"],
     ["2022-06-24T23:58:05", "민탁", "으악 감사해요 이렇게 늦은저녁까지 챙겨주시고ㅠㅠ!"],
     ["2022-06-24T23:58:34", "도현", "민탁님 축하드려요~~!"],
     ["2022-06-24T23:58:36", "도현", ""],
     ["2022-06-24T23:58:55", "금상", "민탁님"],
     ["2022-06-24T23:59:01", "금상", "생일기념 내일 뭐하시나요~"],
     ["2022-06-24T23:59:10", "정원", "가족과 여행?"],
     ["2022-06-24T23:59:12", "금상", "해외여행 가시는건가요!!"],
     ["2022-06-24T23:59:55", "민탁", "일주일쉬면서 가족하고 하와이갑니다~~ 축하감사해요 모두!"],
     ["2022-06-25T00:00:01", "정원", "이제 진짜 생일되셨네요!! 축하합니다!!"],
     ["2022-06-25T00:01:05", "민탁", ""]])
