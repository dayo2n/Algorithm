
// [출처: BOJ] https://www.acmicpc.net/problem/2565
/*
 DP긴한데 문제 해결 방법을 잘 캐치해서 LIS(가장 긴 증가하는 수열) 알고리즘을 이용하는 것이었음
 한 쪽 값으로 정렬 후 다른 쪽 값에서 가장 긴 증가하는 수열의 개수를 찾아 총 개수에서 빼야 함
 꼬인 것이 여러 개 있을 때 뭘 먼저 빼는지에 따라 답이 달라질 수 있음
 때문에 가장 긴 증가하는 수열을 찾아야 하는 거
 아래 링크 참조
 https://www.acmicpc.net/board/view/84972
 */
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

