//
///*
// Combination 조합
// 서로 다른 n개의 원소에서 r개를 중복과 순서에 상관없게 나열하는 것
// */
//
//private func combination<T: Comparable>(_ targetArray: [T], _ targetCount: Int, _ index: Int, _ currentArray: [T]) {
//    if currentArray.count == targetCount {
//        print(currentArray)
//        return
//    }
//    
//    for index in index..<targetArray.count {
//        combination(targetArray, targetNumber, index + 1, currentArray + [targetArray[index]])
//    }
//}
//
//
//private func combination(targetArray: [Int], targetCount: Int, currentArray: [Int]) {
//    if currentArray.count == currentArray {
//        print(currentArray)
//        return
//    }
//    
//    for index in currentArray.count..<targetArray.count {
//        combination(targetArray: targetArray, targetCount: targetCount, currentArray: currentArray + [targetArray[index]])
//    }
//}
