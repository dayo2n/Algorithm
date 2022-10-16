import Foundation

func solution(_ number:[Int]) -> Int {
    var trio: Int = 0
    for first in stride(from: 0, to: number.count, by: 1) {
        for second in stride(from: first+1, to: number.count, by: 1) {
            for third in stride(from: second+1, to: number.count, by: 1) {
                if number[first] + number[second] + number[third] == 0 {
                    trio += 1
                }
            }
        }
    }
    return trio
}
