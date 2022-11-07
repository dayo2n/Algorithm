// #1. [신고자 아이디: 신고한 아이디]와 [신고당한 유저 id: 신고한 유저 id]를 모두 저장해 두 딕셔너리의 값을 모두 순회하여 값을 세는 방법. 시간 제한이 없어 초과는 아니지만 실행시간도 오래 걸림.
//
//import Foundation
//
//func solution(_ id_list:[String], _ report:[String], _ k:Int) -> [Int] {
//
//    var reportsId: [String: Set<String>] = [:]
//    var reportedId: [String: Set<String>] = [:] // 자신을 신고한 유저 아이디의 배열 (중복 방지를 위함)
//    var email: [String: Int] = [:]
//    for id in id_list {
//        reportsId[id] = []
//        reportedId[id] = []
//        email[id] = 0
//    }
//
//    for reportInfo in report {
//        var reports: String = String(reportInfo.split(separator: " ")[0]) // 신고한 id
//        var reported: String = String(reportInfo.split(separator: " ")[1]) // 신고당한 id
//        reportsId[reports]!.insert(reported)
//        reportedId[reported]!.insert(reports)
//    }
//
//    for (key, value) in reportedId {
//        if value.count >= k {
//            for id in id_list {
//                if reportsId[id]!.contains(key) { email[id]! += 1}
//            }
//        }
//    }
//
//    var answer : [Int] = []
//    for id in id_list { answer.append(email[id]!) }
//
//    return answer
//}

// #2. report = [본인 아이디: [신고한 유저들의 아이디]], reported = [본인 아이디: 신고당한 횟수]
//     map, reduce를 이용해 [신고한 유저들의 아이디]를 순회하며 k 이상 신고당하면 1씩 더해 리턴
import Foundation

func solution(_ id_list:[String], _ report:[String], _ k:Int) -> [Int] {
    
    var reports: [String: [String]] = [:] // 자신이 신고한 유저 아이디
    var reported: [String: Int] = [:]
    
    for reportInfo in Set(report) {
        let splitedInfo: [String] = reportInfo.split(separator: " ").map{ String($0) }
        if let _ = reports[splitedInfo[0]] { reports[splitedInfo[0]]!.append(splitedInfo[1]) }
        else { reports[splitedInfo[0]] = [splitedInfo[1]] }
        
        reported[splitedInfo[1]] = (reported[splitedInfo[1]] ?? 0) + 1
    }
    
    return id_list.map { id in
                        return (reports[id] ?? []).reduce(0){
                            $0+((reported[$1] ?? 0) >= k ? 1 : 0)
                        }
    }
}
