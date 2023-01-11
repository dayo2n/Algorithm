
// [출처: 프로그래머스] https://school.programmers.co.kr/learn/courses/30/lessons/150370

// 1안. 문자열 파싱 후 비교

import Foundation

func solution(_ today:String, _ terms:[String], _ privacies:[String]) -> [Int] {
    
    var expired: [Int] = []
    
    let splitToday: [Int] = today.split(separator: ".").map({Int(String($0))!})
    
    var termInDictionary: [String: Int] = [:]
    terms.forEach { term in
                   let splitTerm: [String] = term.split(separator: " ").map({String($0)})
                   termInDictionary[splitTerm[0]] = Int(splitTerm[1])!
                  }
    
    for (index, date) in privacies.enumerated() {
        let privacyType: String = String(date.split(separator: " ")[1])
        let parse: [Int] = date.split(separator: " ")[0].split(separator: ".").map({Int(String($0))!})
        var (year, month, day) = (parse[0], parse[1], parse[2]) // year, month, day
        day = (day - 1) == 0 ? 28 : (day - 1)
        month += termInDictionary[privacyType]!
        if month > 12 {
            year += month / 12
            month = month % 12
            if month == 0 {
                year -= 1
                month = 12
            }
        }
        if parse[2] == 28 { day = 28 }
        else {
            if day == 28 {
                month -= 1
            }
        }
        
        // compare
        if year < splitToday[0] {
            expired.append(index+1)
        } else if year == splitToday[0] {
            if month < splitToday[1] {
                 expired.append(index+1)
            } else if month == splitToday[1] {
                if day < splitToday[2] {
                    expired.append(index+1)
                } else {
                    continue
                }
            } else {
                continue
            }
        } else {
            continue
        }
    }
    
    return expired
}


// 2안. 날짜를 모두 초로 바꾸어 계산
