// [출처: 프로그래머스] https://school.programmers.co.kr/learn/courses/30/lessons/131704#

/*
 접근1. 처음에는 컨테이너 벨트의 상태까지 배열로 저장해서 확인했는데, 시간초과나서 실패
 접근2. 컨테이너는 1~order.count까지 순서대로 정렬되어 있으므로 인덱스 + 1 == 상자값, 커서만 이용해서 해결
 */

import Foundation

func solution(_ order:[Int]) -> Int {
    var assistance: [Int] = [] // 보조 벨트, LIFO
    var cursor: Int = 0
    if Array(1...order.count) == order { return order.count }
    var truckCount: Int = 0
    
    for box in order {
        if box >= cursor + 1 {
            let lastItem: Int = cursor + 1
            if lastItem == box {
                truckCount += 1
                cursor += 1
                continue
            } else if lastItem < box {
                let toAssistance = Array(lastItem..<box)
                assistance.append(contentsOf: toAssistance)
                cursor += box - cursor
                truckCount += 1
                continue
            }
        }
        if !assistance.isEmpty && assistance.last! == box {
            assistance.removeLast()
            truckCount += 1
        } else { break }
    }
    return truckCount
}
