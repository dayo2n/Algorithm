
// [출처: BOJ] https://www.acmicpc.net/problem/14912

let input: [Int] = readLine()!.split(separator: " ").map({Int(String($0))!})
let (n, d) = (input[0], input[1])
var frequency: Int = 0

for number in 1...n {
    frequency += Array("\(number)").filter({ String($0) == String(d) }).count
}

print(frequency)
