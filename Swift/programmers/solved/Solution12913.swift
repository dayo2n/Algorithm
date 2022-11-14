
// [출처: 프로그래머스] https://school.programmers.co.kr/learn/courses/30/lessons/12913#

import Foundation

func solution(_ land:[[Int]]) -> Int{
    var dp: [[Int]] = land
    for row in 0..<(dp.count-1) {
        dp[row+1][0] += max(dp[row][1], max(dp[row][2], dp[row][3]))
        dp[row+1][1] += max(dp[row][0], max(dp[row][2], dp[row][3]))
        dp[row+1][2] += max(dp[row][0], max(dp[row][1], dp[row][3]))
        dp[row+1][3] += max(dp[row][0], max(dp[row][1], dp[row][2]))
    }
    return dp[dp.count-1].max()!
}
