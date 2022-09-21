import Foundation

func solution(_ priorities:[Int], _ location:Int) -> Int {
    var waiting: [(String, Int)] = []
    for (index, priority) in priorities.enumerated() {
        waiting.append((String(UnicodeScalar(UInt8(65 + index))), priority))
    }
    
    let target: String = waiting[location].0
    var order: Int = 1
    
    var maxPriority = waiting.max(by: {$0.1 < $1.1})!.1
    while waiting.count > 0 {
        if waiting.first!.1 >= maxPriority {
            if waiting.first!.0 == target { break }
            waiting.removeFirst()
            maxPriority = waiting.max(by: {$0.1 < $1.1})!.1
            order += 1
        }
        else {
            waiting.append(waiting[0])
            waiting.removeFirst()
        }
    }
    
    return order
}
