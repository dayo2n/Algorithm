func solution(_ s:String) -> String {
//    return s.sorted(by: >).map{return String($0)}.reduce("",+)
    return String(s.sorted(by: >))
}

// 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/12917
