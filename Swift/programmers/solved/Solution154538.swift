/* 시간초과 DFS 풀이*/
//import Foundation
//
//func solution(_ x:Int, _ y:Int, _ n:Int) -> Int {
//    var minCount = Int.max
//    func dfs(_ current: Int, _ count: Int) {
//        var flag = false
//        if current == y {
//            minCount = min(count, minCount)
//            return
//        }
//        if current + n <= y {
//            dfs(current + n, count + 1)
//            flag = true
//        }
//        if current * 2 <= y {
//            dfs(current * 2, count + 1)
//            flag = true
//        }
//        if current * 3 <= y {
//            dfs(current * 3, count + 1)
//            flag = true
//        }
//        if !flag { return }
//    }
//    dfs(x, 0)
//    return minCount == Int.max ? -1 : minCount
//}

/* DP로 해결! (feat. 고뇨짱) */
import Foundation

func solution(_ x:Int, _ y:Int, _ n:Int) -> Int {
    var dp = Array(repeating: y, count: y + 1)
    dp[x] = 0
    for index in x+1..<y+1 {
        if index / 2 >= x && index % 2 == 0 {
            dp[index] = min(dp[index], dp[index / 2] + 1)
        }
        if index / 3 >= x, index % 3 == 0 {
            dp[index] = min(dp[index], dp[index / 3] + 1)
        }
        if index - n >= x {
            dp[index] = min(dp[index], dp[index - n] + 1)
        }
    }
    return dp[y] == y ? -1 : dp[y]
}
