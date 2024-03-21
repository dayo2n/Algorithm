/* 시간초과
import Foundation

func solution(_ numbers:[Int64]) -> [Int64] {
    var results = [Int64]()
    for number in numbers {
        let numberArray = Array(String(number, radix: 2))
        var target = number + 1
        while true {
            let targetArray = Array(String(target, radix: 2))
            var currentArray = numberArray
            if targetArray.count != currentArray.count {
                for _ in 0..<abs(targetArray.count - currentArray.count) {
                    currentArray.insert("0", at: 0)
                }
            }
            let diff = zip(currentArray, targetArray).filter { $0 != $1 }.count
            if diff <= 2 {
                results.append(target)
                break
            }
            target += 1
        }
    }
    return results
}
 /*
  테스트 1 〉    통과 (15.38ms, 16.8MB)
  테스트 2 〉    통과 (4999.60ms, 38.4MB)
  테스트 3 〉    통과 (6.90ms, 16.7MB)
  테스트 4 〉    통과 (20.72ms, 16.5MB)
  테스트 5 〉    통과 (94.43ms, 16.5MB)
  테스트 6 〉    통과 (62.33ms, 16.8MB)
  테스트 7 〉    실패 (시간 초과)
  테스트 8 〉    통과 (7923.29ms, 35.6MB)
  테스트 9 〉    실패 (시간 초과)
  테스트 10 〉    실패 (시간 초과)
  테스트 11 〉    실패 (시간 초과)
  */
*/

// 짝수: 최하위비트가 무조건 0이니까 1만 올려주면 돼서 (현재값 + 1)을 리턴
// 홀수: 최하비트부터 확인하여 처음으로 나오는 비트 01을 10으로 바꾸면 큰 수 중 최솟값을 리턴할 수 있음
import Foundation

func solution(_ numbers:[Int64]) -> [Int64] {
    var results = [Int64]()
    for number in numbers {
        if number % 2 == 0 {
            results.append(number + 1)
        } else {
            var array = Array(String(number, radix: 2))
            array.insert("0", at: 0)
            for index in stride(from: array.count - 1, to: 0, by: -1) {
                if array[index - 1] == "0", array[index] == "1" {
                    array[index - 1] = "1"
                    array[index] = "0"
                    results.append(Int64(Int(String(array), radix: 2)!))
                    break
                }
            }
        }
    }
    return results
}

/*
 테스트 1 〉    통과 (1.74ms, 16.9MB)
 테스트 2 〉    통과 (347.59ms, 38.2MB)
 테스트 3 〉    통과 (0.28ms, 16.5MB)
 테스트 4 〉    통과 (1.53ms, 16.8MB)
 테스트 5 〉    통과 (3.51ms, 16.8MB)
 테스트 6 〉    통과 (1.72ms, 16.5MB)
 테스트 7 〉    통과 (418.73ms, 36.6MB)
 테스트 8 〉    통과 (409.33ms, 35.6MB)
 테스트 9 〉    통과 (582.58ms, 35.1MB)
 테스트 10 〉    통과 (1565.21ms, 38MB)
 테스트 11 〉    통과 (1265.52ms, 38.3MB)
 */
