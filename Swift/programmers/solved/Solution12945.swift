// 1. 반복문으로 풀기
//func solution(_ n:Int) -> Int {
//    var fibo1 = 0
//    var fibo2 = 1
//    var temp: Int
//    for fibo in (2...n) {
//        temp = fibo1 % 1234567
//        fibo1 = fibo2 % 1234567
//        fibo2 = temp + fibo1
//    }
//    return fibo2 % 1234567
//}

// 2. dp로 풀기
func solution(_ n:Int) -> Int {
    var dp:[Int] = [0, 1]
    for fibo in (2...n) {
        dp.append((dp[fibo-1] + dp[fibo-2]) % 1234567)
    }
    return dp[n]
}
