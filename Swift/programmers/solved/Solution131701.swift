/* n^3이라 시간초과남 (20/100)
 import Foundation

 func solution(_ elements:[Int]) -> Int {
     var sequence = Set<Int>()
     let count = elements.count
     for index in 0..<count {
         let numberOfSequence = index + 1
         for number in 0..<count {
             var endIndex = number + numberOfSequence
             if endIndex < count {
                 sequence.insert(elements[number..<endIndex].reduce(0,+))
             } else {
                 var sum = elements[number..<count].reduce(0,+)
                 endIndex -= elements.count
                 sum += elements[0..<endIndex].reduce(0,+)
                 sequence.insert(sum)
             }
         }
     }
     return sequence.count
 }
 */

// DP로 해결!
import Foundation

func solution(_ elements:[Int]) -> Int {
    var sequence = Set(elements)
    let count = elements.count
    var dp = elements
    for index in 1..<count {
        for number in 0..<count {
            var endIndex = number + index
            if endIndex >= count {
                endIndex -= elements.count
            }
            dp[number] += elements[endIndex]
        }
        dp.forEach { value in sequence.insert(value) }
    }
    return sequence.count
}
