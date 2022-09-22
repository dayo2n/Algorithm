func solution(_ s:String) -> Bool {
    guard s.count == 4 || s.count == 6 else { return false }
//    let numbers = Array(0...9).map{String($0)}
//    return s.filter{!numbers.contains(String($0))} == ""
    return Int(s) != nil
}

// 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/12918
