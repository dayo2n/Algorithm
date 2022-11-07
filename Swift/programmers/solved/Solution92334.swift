
import Foundation

func solution(_ id_list:[String], _ report:[String], _ k:Int) -> [Int] {
    
    var reportsId: [String: Set<String>] = [:]
    var reportedId: [String: Set<String>] = [:] // 자신을 신고한 유저 아이디의 배열 (중복 방지를 위함)
    var email: [String: Int] = [:]
    for id in id_list {
        reportsId[id] = []
        reportedId[id] = []
        email[id] = 0
    }
    
    for reportInfo in report {
        var reports: String = String(reportInfo.split(separator: " ")[0]) // 신고한 id
        var reported: String = String(reportInfo.split(separator: " ")[1]) // 신고당한 id
        reportsId[reports]!.insert(reported)
        reportedId[reported]!.insert(reports)
    }
    
    for (key, value) in reportedId {
        if value.count >= k {
            for id in id_list {
                if reportsId[id]!.contains(key) { email[id]! += 1}
            }
        }
    }
    
    var answer : [Int] = []
    for id in id_list { answer.append(email[id]!) }
    
    return answer
}
