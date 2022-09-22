import Foundation

func solution(_ n:Int) -> Int {
    return Int(String(String(n, radix: 3).reversed()), radix: 3)!
}

// 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/68935
