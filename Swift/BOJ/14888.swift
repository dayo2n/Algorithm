
// [출처: BOJ] https://www.acmicpc.net/problem/14888

let N: Int = Int(readLine()!)!

var operands: [Int] = readLine()!.split(separator: " ").map({Int(String($0))!})
var operators: [Int] = readLine()!.split(separator: " ").map({Int(String($0))!}) // +, -, *, /
var (min, max): (Int, Int) = (.max, .min)

func backtracking(_ result: Int, _ index: Int) {
    if index == N {
        if result < min {
            min = result
        }
        if result > max {
            max = result
        }
    }
    else {
        for i in stride(from: 0, to: 4, by: 1) {
            if operators[i] > 0 {
                operators[i] -= 1
                switch i {
                case 0:
                    backtracking(result + operands[index], index + 1)
                case 1:
                    backtracking(result - operands[index], index + 1)
                case 2:
                    backtracking(result * operands[index], index + 1)
                case 3:
                    backtracking(result / operands[index], index + 1)
                default:
                    continue
                }
                operators[i] += 1
            }
        }
    }
}

backtracking(operands[0], 1)
print(max)
print(min)
