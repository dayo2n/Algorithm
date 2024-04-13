
// [출처: BOJ] https://www.acmicpc.net/problem/4920
/*
 브루트포스로 가능한 케이스 모두 처리해야 함. 13가지 경우 처리~!
 DFS로 해결못한다...
 */
var testcase = 1
while true {
    let n = Int(readLine()!.split(separator: " ")[0])!
    if n == 0 { break }
    var board = [[Int]]()
    for _ in 0..<n {
        board.append(readLine()!.split(separator: " ").map { Int($0)! })
    }
    var maxSum = Int.min
    for row in 0..<n {
        for col in 0..<n {
            /*
             ㅁㅁㅁㅁ
             */
            if n - col >= 4 {
                maxSum = max(maxSum, board[row][col..<col + 4].reduce(0, +))
            }
            /*
             ㅁ
             ㅁ
             ㅁ
             ㅁ
             */
            if n - row >= 4 {
                maxSum = max(
                    maxSum,
                    [
                        board[row][col],
                        board[row + 1][col],
                        board[row + 2][col],
                        board[row + 3][col]
                    ].reduce(0, +)
                )
            }
            /*
             ㅁㅁ
              ㅁㅁ
             */
            if n - row >= 2, n - col >= 3 {
                maxSum = max(
                    maxSum,
                    [
                        board[row][col], board[row][col+1],
                        board[row+1][col+1], board[row+1][col+2]
                    ].reduce(0, +)
                )
            }
            /*
              ㅁ
             ㅁㅁ
             ㅁ
             */
            if col >= 1, n - row >= 3 {
                maxSum = max(
                    maxSum,
                    [
                        board[row][col],
                        board[row + 1][col - 1], board[row + 1][col],
                        board[row + 2][col - 1]
                    ].reduce(0, +)
                )
            }
            /*
             ㅁㅁㅁ
                ㅁ
             */
            if n - col >= 3, n - row >= 2 {
                maxSum = max(
                    maxSum,
                    [
                        board[row][col], board[row][col + 1], board[row][col + 2],
                        board[row + 1][col + 2]
                    ].reduce(0, +)
                )
            }
            /*
               ㅁ
               ㅁ
             ㅁ ㅁ
             */
            if col >= 1, n - row >= 3 {
                maxSum = max(
                    maxSum,
                    [
                        board[row][col],
                        board[row + 1][col],
                        board[row + 2][col - 1], board[row + 2][col]
                    ].reduce(0, +)
                )
            }
            /*
             ㅁ
             ㅁㅁㅁ
             */
            if n - row >= 2, n - col >= 3 {
                maxSum = max(
                    maxSum,
                    [
                        board[row][col],
                        board[row + 1][col], board[row + 1][col + 1], board[row + 1][col + 2]
                    ].reduce(0, +)
                )
            }
            /*
             ㅁㅁ
             ㅁ
             ㅁ
             */
            if n - row >= 3, n - col >= 2 {
                maxSum = max(
                    maxSum,
                    [
                        board[row][col], board[row][col + 1],
                        board[row + 1][col],
                        board[row + 2][col]
                    ].reduce(0, +)
                )
            }
            /*
             ㅁㅁㅁ
              ㅁ
             */
            if n - row >= 2, n - col >= 3 {
                maxSum = max(
                    maxSum,
                    [
                        board[row][col], board[row][col + 1], board[row][col + 2],
                        board[row + 1][col + 1]
                    ].reduce(0, +)
                )
            }
            /*
               ㅁ
             ㅁ ㅁ
               ㅁ
             */
            if col >= 1, n - row >= 3 {
                maxSum = max(
                    maxSum,
                    [
                        board[row][col],
                        board[row + 1][col - 1], board[row + 1][col],
                        board[row + 2][col]
                    ].reduce(0, +)
                )
            }
            /*
               ㅁ
             ㅁ ㅁ ㅁ
             */
            if col >= 1, col + 1 < n, n - row >= 2 {
                maxSum = max(
                    maxSum,
                    [
                        board[row][col],
                        board[row + 1][col - 1], board[row + 1][col], board[row + 1][col + 1]
                    ].reduce(0, +)
                )
            }
            /*
             ㅁ
             ㅁㅁ
             ㅁ
             */
            if n - col >= 2, n - row >= 3 {
                maxSum = max(
                    maxSum,
                    [
                        board[row][col],
                        board[row + 1][col], board[row + 1][col + 1],
                        board[row + 2][col]
                    ].reduce(0, +)
                )
            }
            /*
             ㅁㅁ
             ㅁㅁ
             */
            if n - col >= 2, n - row >= 2 {
                maxSum = max(
                    maxSum,
                    [
                        board[row][col], board[row][col + 1],
                        board[row + 1][col], board[row + 1][col + 1]
                    ].reduce(0, +)
                )
            }
        }
    }
    print("\(testcase). \(maxSum)")
    testcase += 1
}
