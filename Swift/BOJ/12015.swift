
// [출처: BOJ] https://www.acmicpc.net/problem/12015
/*
 LIS에 해당하는 값을 구해 담음
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
    
    /* 중간에 낄 자리가 있는지 보고 삽입 */
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
