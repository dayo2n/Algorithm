func solution(_ arr:[Int]) -> [Int] {
    if arr.count <= 1 { return [-1] }
    let lowest = arr.min()
    return arr.filter{$0 != lowest} // 한 tc가 시간초과
}
