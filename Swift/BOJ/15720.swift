
// [출처: BOJ] https://www.acmicpc.net/problem/15720

var input: [Int] = readLine()!.split(separator: " ").map({Int($0)!})
let (burger, side, drink) = (input[0], input[1], input[2])

var burgers: [Int] = readLine()!.split(separator: " ").map({Int($0)!}).sorted(by: >)
var sides: [Int] = readLine()!.split(separator: " ").map({Int($0)!}).sorted(by: >)
var drinks: [Int] = readLine()!.split(separator: " ").map({Int($0)!}).sorted(by: >)

print(burgers.reduce(0,+) + sides.reduce(0,+) + drinks.reduce(0,+))

let minSet = min(min(burger, side), drink)
let maxSet = max(max(burger, side), drink)
var discounted: Int = 0
for index in 0..<maxSet {
    if index < minSet {
        discounted += Int(Double(burgers[index] + sides[index] + drinks[index]) * 0.9)
    } else {
        if index < burger { discounted += burgers[index] }
        if index < side { discounted += sides[index] }
        if index < drink { discounted += drinks[index] }
    }
}

print(discounted)
