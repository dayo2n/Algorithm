// [출처: 프로그래머스] https://school.programmers.co.kr/learn/courses/30/lessons/64061


import Foundation

func solution(_ board:[[Int]], _ moves:[Int]) -> Int {
    var curBoard: [[Int]] = board
    var doll: [Int] = Array(repeating: 0, count: board.count) // 꼭대기 row의 값(인형 종류)을 저장. 0이면 빈 column.
    var pointerRow: [Int] = Array(repeating: -1, count: board.count) // 포인터에 위치(row)를 저장
    
    var count: Int = 0
    for row in 0..<board.count {
        if count == board.count { break }
        for col in 0..<board[row].count {
            if doll[col] == 0 && board[row][col] > 0 {
                doll[col] = board[row][col]
                pointerRow[col] = row
                count += 1
            }
        }
    }
    
    var basket: [Int] = []
    count = 0
    
    for move in moves { // row는 pointerRow, column은 move-1
        var col: Int = move - 1
        if doll[col] > 0 {
            if !basket.isEmpty && basket.last! == doll[col] {
                basket.popLast()
                count += 1
            }
            else { basket.append(doll[col]) }
            
            curBoard[pointerRow[col]][col] = 0
            pointerRow[col] += 1 // board.count보다 커지면 column이 비게 된 것.
            doll[col] = pointerRow[col] >= board.count ? 0 : curBoard[pointerRow[col]][col]
        }
    }
    
    return count * 2
}
