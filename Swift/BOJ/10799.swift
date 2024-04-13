
// [출처: BOJ] https://www.acmicpc.net/problem/10799
/*
 런타임 에러
 split을 ""을 기준으로 잘라주니 엑스코드에서는 잘 돌아가지만 백준 컴파일러는 오류를 냈음.
 split하고 맵핑 안해주고 String을 Array로 감싸서 순회하도록 수정해서 해결~!
 */

enum BracketType: String {
    case open = "("
    case close = ")"
}

var words = readLine()!

var stack = [BracketType]()
var isLaser = false
var sum = 0

for word in Array(words) {
    let target = BracketType(rawValue: String(word))
    if target == .open  {
        stack.append(.open)
        isLaser = true
    } else {
        guard !stack.isEmpty else { continue }
        _ = stack.popLast()
        sum += isLaser ? stack.count : 1
        isLaser = false
    }
}

print(sum)
