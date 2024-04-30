
// [출처: BOJ] https://www.acmicpc.net/problem/3226
/*
 시간에 따른 돈 계산하는 문제
 */


let n = Int(readLine()!)!
var totalCharge = 0
for _ in 0..<n {
    var input = readLine()!.split(separator:  ":")
    var hour = Int(input[0])!
    input = input[1].split(separator: " ")
    var minute = Int(input[0])!
    var duration = Int(input[1])!
    
    while duration > 0 {
        totalCharge += (7 <= hour && hour < 19) ? 10 : 5
        duration -= 1
        minute += 1
        if minute > 59 {
            minute -= 60
            hour += 1
        }
        if hour > 23 {
            hour = 0
        }
    }
}

print(totalCharge)
