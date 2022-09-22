import Foundation

func solution(_ s:String) -> [Int] {
    
    var removed: Int = 0
    var transformed: Int = 0
    var target = s
    
    while(target.count > 1) {
        var numberOfZero = target.filter{ $0 == "0" }.count
        removed += numberOfZero
        target = String(target.count - numberOfZero, radix: 2)
        transformed += 1
    }
    return [transformed, removed]
}

// 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/70129
