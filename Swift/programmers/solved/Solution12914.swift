
// [출처: 프로그래머스] https://school.programmers.co.kr/learn/courses/30/lessons/12914

func solution(_ n:Int) -> Int {
    if n == 1 { return 1 }
    var prev: Int = 1
    var cur: Int = 2
    var position: Int = 2
    var tmp: Int
    
    while position < n {
        tmp = prev
        prev = cur % 1234567
        cur = (cur + tmp) % 1234567
        position += 1
    }
    
    return cur
}
