import Foundation

func solution(_ d:[Int], _ budget:Int) -> Int {
    var sorted: [Int] = d.sorted(by: >)
    var sum: Int = sorted.reduce(0, +)
    while sum > budget {
        sum -= sorted.removeFirst()
    }
    return sorted.count
}
