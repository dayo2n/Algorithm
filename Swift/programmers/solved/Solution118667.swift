// [출처: 프로그래머스] https://school.programmers.co.kr/learn/courses/30/lessons/118667
import Foundation

func solution(_ queue1:[Int], _ queue2:[Int]) -> Int {
    var queue: [Int] = queue1 + queue2
    var sumQ1: Int = queue1.reduce(0,+) // left
    var average: Int = queue.reduce(0,+) / 2
    var left: Int = 0
    var right: Int = queue1.count - 1
    
    var count: Int = 0
    while right != queue.count - 1 {
        if sumQ1 > average {
            sumQ1 -= queue[left]
            left += 1
        }
        else if sumQ1 < average {
            right += 1
            sumQ1 += queue[right]
        } else {
            return count
        }
        count += 1
    }
    return sumQ1 == average ? count : -1
}

// queue1, queue2를 각각 두고 append(removeFirst()) 하는 방식은
// removeFirst()의 시간복잡도가 O(n)이기 때문에 시간 초과 발생

// queue들을 하나에 이어붙이고 커서로 쓸 left, right 변수를 선언해
// 포인터를 이동시키면서 값만 변경하는 방식으로 해결
