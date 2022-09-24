import Foundation

func solution(_ A:[Int], _ B:[Int]) -> Int
{
    return zip(A.sorted(by: <), B.sorted(by: >)).map(*).reduce(0,+)
}

// 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/12941
