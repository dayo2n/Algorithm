
// [출처: BOJ] https://www.acmicpc.net/problem/15989
/*
 ㄹㅇ 이런건 누가 다들 어케 푸는거냐...
 점화식 찾기 어렵따...
 근접하게 접근은 했는데 까빙
 방식은 여러 개 일수도 있는듯...
 아래 링크 참고
 https://velog.io/@lchyung1998/어려워요알고리즘-BOJ-15989-1-2-3-더하기-4
 */

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
