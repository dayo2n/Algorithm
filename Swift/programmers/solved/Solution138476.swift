
import Foundation

func solution(_ k:Int, _ tangerine:[Int]) -> Int {
    var tangerines: [Int: Int] = [:]
    for size in tangerine {
        if let _ = tangerines[size] { tangerines[size]! += 1}
        else { tangerines[size] = 1}
    }
    var sum: Int = 0
    var variety: Int = 0
    for item in tangerines.sorted(by: {$0.value > $1.value}) {
        sum += item.value
        variety += 1
        if sum >= k { break }
    }
    return variety
}
