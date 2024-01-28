
/*
 Combination 조합
 순서에 상관없게 나열하는 것
 */

private func combination<T: Comparable>(_ targetArray: [T], _ targetNumber: Int, _ index: Int, _ currentArray: [T]) {
    if currentArray.count == targetNumber {
        print(currentArray)
        return
    }
    
    for index in index..<targetArray.count {
        combination(targetArray, targetNumber, index + 1, currentArray + [targetArray[index]])
    }
}
