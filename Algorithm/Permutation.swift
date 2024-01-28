
/*
 Permutation 순열
 서로 다른 n개의 원소에서 r개를 중복없이 순서에 상관있게 선택 혹은 나열하는 것
 */

private func permutation<T: Comparable>(_ targetArray: [T], _ targetNumber: Int) -> [[T]] {
    var result = [[T]]()
    if targetArray.count < targetNumber { return result }
    var visited = Array(repeating: false, count: targetArray.count)
    
    func permute(_ currentArray: [T]) {
        if currentArray.count == targetNumber {
            result.append(currentArray)
            return
        }
        for index in 0..<targetArray.count {
            if visited[index] {
                continue
            }
            visited[index] = true
            permute(currentArray + [targetArray[index]])
            visited[index] = false
        }
    }
    
    permute([])
    return result
}
