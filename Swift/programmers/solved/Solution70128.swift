import Foundation

func solution(_ a:[Int], _ b:[Int]) -> Int {
    return zip(a, b).map(*).reduce(0,+)
}

// 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/70128
