import Foundation

func solution(_ n:Int) -> Int
{
    var answer:Int = n + 1
    let binaryString: String = String(n, radix: 2)
    let countOfOne: Int = binaryString.filter{$0=="1"}.count
    
    while(true) {
        if String(answer, radix: 2).filter{$0=="1"}.count == countOfOne { break }
        answer += 1
    }
    return answer
}

// 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/12911
