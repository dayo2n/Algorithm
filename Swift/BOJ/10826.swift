
// [출처: BOJ] https://www.acmicpc.net/problem/10826

/*
 아래 코드는 런타임 에러 발생; Int(UInt까지)의 범위를 벗어나서.
 */

let n: Int = Int(readLine()!)!

var dp: [UInt] = Array(repeating: 0, count: n+1)

func fibonacci(_ n: Int) -> UInt {
    for index in 1...n {
        if index < 3 { dp[index] = 1 }
        else { dp[index] = dp[index - 1] + dp[index - 2] }
    }
    return dp[n]
}

print(fibonacci(n))

// Swift에서 큰 수 처리하는 방법. 아래 포스트 참고해서 다시 공부하기.
// https://m.blog.naver.com/gustn3964/222246492360
