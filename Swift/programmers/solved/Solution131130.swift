// [출처: 프로그래머스] https://school.programmers.co.kr/learn/courses/30/lessons/131130

import Foundation

func solution(_ cards:[Int]) -> Int {
    var boxes: [Int: [Int]] = [:]
    var opened: [Bool] = Array(repeating: false, count: cards.count)
    
    for index in stride(from: 0, to: cards.count, by:1) {
        var card: Int = cards[index] - 1
        if opened[card] { continue }
        boxes[boxes.count] = []
        
        var isNextOpened: Bool = false
        repeat {
            boxes[boxes.count-1]!.append(card)
            opened[card] = true
            card = cards[card] - 1
            isNextOpened = opened[card]
        } while !isNextOpened
    }
    
    if boxes.count == 1 { return 0 }
    var sortedBoxes = boxes.sorted{ $0.value.count > $1.value.count }.map{$0.value.count}
    return sortedBoxes[0] * sortedBoxes[1]
}
