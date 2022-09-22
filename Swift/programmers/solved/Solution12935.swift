func solution(_ arr:[Int]) -> [Int] {
    if arr.count <= 1 { return [-1] }
    let lowest = arr.min()
    return arr.filter{$0 != lowest} // 실행속도 훨씬 빠름
//    return arr.filter{$0 != arr.min()} // 한 tc가 시간초과
}

// 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/12935
