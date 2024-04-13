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
