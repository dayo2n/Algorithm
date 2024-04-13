struct Pair {
    let left: Int
    let right: Int
    
    static func <(lhs: Pair, rhs: Pair) -> Bool {
        return lhs.left < rhs.left
    }
}

let numberOfCable = Int(readLine()!)!
var pairs = [Pair]()
for _ in 0..<numberOfCable {
    let input = readLine()!.split(separator: " ").map { Int($0)! }
    pairs.append(Pair(left: input[0], right: input[1]))
}
pairs.sort(by: <)

var dp = [Int]()
for (index, cable) in pairs.enumerated() {
    var maxValue = 1
    for prevIndex in 0..<index {
        if pairs[prevIndex].right < cable.right {
            maxValue = max(maxValue, dp[prevIndex] + 1)
        }
    }
    dp.append(maxValue)
}

if let max = dp.max() {
    print(max == 1 ? 0 : numberOfCable - dp.max()!)
}
