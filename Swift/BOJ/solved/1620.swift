
// [출처: BOJ] https://www.acmicpc.net/problem/1620
import Foundation

let input: [String] = readLine()!.split(separator: " ").map{ String($0) }
let N: Int = Int(input[0])!
let M: Int = Int(input[1])!

var bookByName: [String: Int] = [:]
var bookByIndex: [String] = []

for _ in 0..<N {
    let pocketmon: String = readLine()!
    bookByName[pocketmon] = bookByIndex.count
    bookByIndex.append(pocketmon)
}

for _ in 0..<M {
    let quiz: String = readLine()!
    
    // 이름에는 영문만 포함하므로 첫 글자가 숫자면 입력값이 숫자인 것
    if quiz[quiz.startIndex].isNumber { print(bookByIndex[Int(quiz)!-1]) }
    else { print(bookByName[quiz]! + 1) }
}

