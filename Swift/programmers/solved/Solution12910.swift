func solution(_ arr:[Int], _ divisor:Int) -> [Int] {
    
    let quota = arr.filter{$0 % divisor == 0}
    if quota.count == 0 { return [-1]}
    return quota.sorted()
}
