// [출처: 프로그래머스] https://school.programmers.co.kr/learn/courses/30/lessons/132265

// 방법1. 철수는 빈 Set에서 시작, 동생들은 topping에서 하나씩 줄여갈 때마다 이를 Set으로 변환해 그 수를 비교: 시간 초과
import Foundation

func solution(_ topping:[Int]) -> Int {
    var answer: Int = 0
    var ChulsooHas: Set<Int> = []
    var brothersHave: [Int] = topping.reversed() // removeLast()의 시간복잡도가 더 작음
    for cut in topping {
        ChulsooHas.insert(cut)
        brothersHave.removeLast()
        if ChulsooHas.count == Set(brothersHave).count { answer += 1 }
    }
    return answer
}

// 방법2. 동생들의 topping 종류 별 수를 따로 저장하고, 남은 토핑들의 수를 줄여가면서 비교: 해결
import Foundation

func solution(_ topping:[Int]) -> Int {
    var answer: Int = 0
    var ChulsooHas: Set<Int> = []
    var brothersHave: Int = Set(topping).count
    var restTopping: [Int] = Array(repeating: 0, count: topping.max()! + 1) // restTopping[0]은 쓰지 않음
    for type in topping { restTopping[type] += 1}
    for cut in topping {
        ChulsooHas.insert(cut)
        if restTopping[cut] > 0 {
            restTopping[cut] -= 1
            if restTopping[cut] == 0 { brothersHave -= 1 }
        }
        if ChulsooHas.count == brothersHave { answer += 1 }
    }
    return answer
}
