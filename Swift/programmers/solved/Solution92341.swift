
// [출처: 프로그래머스] https://school.programmers.co.kr/learn/courses/30/lessons/92341

import Foundation

func getDiffMin(_ from: String, _ to: String) -> Int {
    let splitFrom = from.split(separator: ":").map{Int($0)!}
    let splitTo = to.split(separator: ":").map{Int($0)!}
    if splitFrom[0] == splitTo[0] { return splitTo[1] - splitFrom[1] }
    return (splitTo[0]-splitFrom[0])*60 + splitTo[1] - splitFrom[1]
}

func solution(_ fees:[Int], _ records:[String]) -> [Int] {
    
    var totalParkingTime: [String: Int] = [:] // 누적 주차 시간
    var totalParkingCharge: [String: Int] = [:]
    var parkingIn: [String: String] = [:]
    
    for record in records {
        let info = record.split(separator: " ").map{String($0)}
        let carNumber = info[1]
        
        if info[2] == "IN" { // 입차
            parkingIn[carNumber] = info[0]
        } else { // 출차
            let minDiff = getDiffMin(parkingIn[carNumber]!, info[0])
            if let _ = totalParkingTime[carNumber] {
                totalParkingTime[carNumber]! += minDiff
            } else { totalParkingTime[carNumber] = minDiff }
            parkingIn[carNumber] = nil
        }
    }
    
    for parking in parkingIn {
        let minDiff = getDiffMin(parking.value, "23:59")
        if let _ = totalParkingTime[parking.key] {
                totalParkingTime[parking.key]! += minDiff
        } else { totalParkingTime[parking.key] = minDiff }
    }

    for parkingTime in totalParkingTime {
        let charge = fees[1] + Int(ceil((parkingTime.value <= fees[0] ? 0 : Double(parkingTime.value-fees[0])) / Double(fees[2])))*fees[3]
        totalParkingCharge[parkingTime.key] = charge
    }
    return totalParkingCharge.sorted{$0.key < $1.key}.map{$0.value}
}
