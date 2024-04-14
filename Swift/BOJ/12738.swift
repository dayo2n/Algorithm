
// [출처: BOJ] https://www.acmicpc.net/problem/12378
/*
 12015랑 답 같음
 */

let N = Int(readLine()!)!
let array = readLine()!.split(separator: " ").map { Int($0)! }
var LIS = [Int]()

for (index, number) in array.enumerated() {
    if index == 0 {
        LIS.append(number)
        continue
    }
    if let last = LIS.last {
        if last < number {
            LIS.append(number)
            continue
        }
    }
    
    var (low, high) = (0, LIS.count - 1)
    while low <= high {
        let mid = (low + high) / 2
        if LIS[mid] < number {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }
    
    LIS[low] = number
}

print(LIS.count)
