// [출처: 프로그래머스] https://school.programmers.co.kr/learn/courses/30/lessons/12949
import Foundation

func solution(_ arr1:[[Int]], _ arr2:[[Int]]) -> [[Int]] {
    
    // 행과 열을 바꾸어 arr2를 새 배열에 담음
    var jCol: [[Int]] = Array(repeating: Array(repeating: 0, count: arr2.count), count: arr2.first!.count)

    for (colIndex, col) in arr2.enumerated() {
        for (jColIndex, value) in col.enumerated() {
            jCol[jColIndex][colIndex] = value
        }
    }
    
    var answer: [[Int]] = Array(repeating: Array(repeating: 0, count: arr2.first!.count), count: arr1.count)// arr1.count * arr2.first.count
    for (rowIndex, row) in arr1.enumerated() {
        for (colIndex, col) in jCol.enumerated() {
            answer[rowIndex][colIndex] = zip(row, col).map(*).reduce(0,+)
        }
    }
    return answer
}
