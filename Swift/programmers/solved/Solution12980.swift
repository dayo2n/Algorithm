// [출처: 프로그래머스] https://school.programmers.co.kr/learn/courses/30/lessons/12980


// 테스트케이스는 모두 맞지만 효율성 테스트 10개 중 하나만 통과하는 코드. 2진법 사용
import Foundation

func solution(_ n:Int) -> Int
{ return String(n, radix: 2).reduce(0) { $0 + Int(String($1))!} }



// 효율성 테스트까지 모두 통과한 코드
import Foundation
 
func solution(_ n:Int) -> Int {
    var distance: Int = n
    var battery: Int = 0
    
    while distance > 0 {
        battery += distance % 2
        distance /= 2
    }
    return battery
}

// => 수가 커질수록 이진수로 변환한 길이가 커져서 시간차이가 많이 나는 것 같다...
