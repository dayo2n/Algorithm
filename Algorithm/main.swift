let testcase = Int(readLine()!)!

for _ in 0..<testcase {
    var dp = Array(repeating: 0, count: 10_001)
    dp[0] = 1
    let n = Int(readLine()!)!
    if n == 1 {
        print(1)
        continue
    } else if n == 2 {
        print(2)
        continue
    }
    for target in 1...3 {
        for index in target...n {
            dp[index] += dp[index - target]
        }
    }
    print(dp[n])
}
