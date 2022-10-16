import Foundation

func solution(_ n:Int, _ words:[String]) -> [Int] {
    var number: Int = 1 // 사람의 번호
    var turn: Int = 1 // 그 사람의 몇 번째 차례인지
    for (index, word) in words.enumerated() {
        if index > 0 && words[0...(index-1)].contains(word) {
            return [number, turn]
        }
        else {
            if index > 0 {
                if words[index-1].last! != words[index].first! {
                    return [number ,turn]
                }
            }
            if number == n {
                number = 1
                turn += 1
            } else  {
                number += 1
            }
        }
    }
    return [0, 0]
}
