func getSum(_ first: Int, _ last: Int, _ cnt: Int) -> Int {
    if cnt % 2 == 0 { return (first + last) * (cnt / 2) }
    return (first + last) * (cnt / 2) + (first + last) / 2
}

func solution(_ a:Int, _ b:Int) -> Int64 {
    if a == b { return Int64(a) }
    // return Int64(Array(min(a, b)...max(a, b)).reduce(0,+)) // 시간초과
    return Int64(getSum(min(a, b), max(a, b), max(a, b) - min(a, b) + 1))
}
