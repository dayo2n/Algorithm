let N = Int(readLine()!)!

if N == 1 {
    print(10)
    exit(0)
}
var dp = [[Int]]()
dp.append(Array(repeating: 0, count: 10))
dp.append(Array(repeating: 1, count: 10))

for length in 2...N {
    var array = Array(repeating: 0, count: 10)
    for number in 0..<10 {
        array[number] = dp[length - 1][number..<10].reduce(0, +) % 10_007
    }
    dp.append(array)
}

print(dp[N].reduce(0, +) % 10_007)
