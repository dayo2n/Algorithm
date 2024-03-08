/* 시간초과 1
 import Foundation

 func solution(_ numbers:[Int]) -> [Int] {
     var results = [Int]()
     for (index, number) in numbers.enumerated() {
         if index == numbers.count {
             results.append(-1)
             break
         }
         let biggerNumbers = numbers[index + 1..<numbers.count].filter{ $0 > number}
         results.append(biggerNumbers.isEmpty ? -1 : biggerNumbers.first!)
     }
     return results
 }
 */

/* 시간초과 2
 import Foundation

 func solution(_ numbers:[Int]) -> [Int] {
     var results = [Int]()
     for (index, number) in numbers.enumerated() {
         if index == numbers.count - 1 {
             results.append(-1)
             break
         }
         let numbersBehind = numbers[index + 1..<numbers.count]
         for (order, behind) in numbersBehind.enumerated() {
             if behind > number {
                 results.append(behind)
                 break
             }
             if order == numbersBehind.count - 1 {
                 results.append(-1)
             }
         }
     }
     return results
 }

 */

/* 시간초과 3. Stack을 사용해 뒤에서부터 담으면서 확인하는 로직
 import Foundation

 func solution(_ numbers:[Int]) -> [Int] {
     var stack = [Int]()
     var results = [-1]
     stack.append(numbers.last!)
     for index in stride(from: numbers.count - 2, to: -1, by: -1) {
         while !stack.isEmpty {
             if numbers[index] < stack.last! {
                 results.insert(stack.last!, at: 0)
                 break
             } else {
                 stack.removeLast()
                 if stack.isEmpty {
                     results.insert(-1, at: 0)
                     break
                 }
             }
         }
         stack.append(numbers[index])
     }

     return results
 }
 */

// insert(element, at: 0)은 O(n)이라서 reversed()를 사용하는 것으로 변경
import Foundation

func solution(_ numbers:[Int]) -> [Int] {
    var stack = [Int]()
    var results = [-1]
    stack.append(numbers.last!)
    for index in stride(from: numbers.count - 2, to: -1, by: -1) {
        while !stack.isEmpty {
            if numbers[index] < stack.last! {
                results.append(stack.last!)
                break
            } else {
                stack.removeLast()
                if stack.isEmpty {
                    results.append(-1)
                    break
                }
            }
        }
        stack.append(numbers[index])
    }

    return results.reversed()
}
