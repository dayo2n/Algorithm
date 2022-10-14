
import Foundation

func isPrime(_ target: Int) -> Bool {
    for number in stride(from: 2, to: Int(sqrt(Double(target))) + 1, by: 1) {
        if target % number == 0 { return false }
    }
    return true
}

func solution(_ nums:[Int]) -> Int {
    var answer: Int = 0
    for first in stride(from: 0, to: nums.count, by: 1) {
        for second in stride(from: first+1, to: nums.count, by: 1) {
            for third in stride(from: second+1, to: nums.count, by: 1) {
                if isPrime(nums[first] + nums[second] + nums[third]) { answer += 1}
            }
        }
    }
    return answer
}
