
// [출처: BOJ] https://www.acmicpc.net/problem/11053

let N = Int(readLine()!)!
let array = readLine()!.split(separator: " ").map { Int($0)! }
var LIS = [Int]()

for (index, number) in array.enumerated() {
    if index == 0 {
        LIS.append(1)
        continue
    }
    var maxValue = 1
    for prevIndex in 0..<index {
        if number > array[prevIndex] {
            maxValue = max(maxValue, LIS[prevIndex] + 1)
        }
    }
    LIS.append(maxValue)
}

print(LIS.max()!)
