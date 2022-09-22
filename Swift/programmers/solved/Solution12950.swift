func solution(_ arr1:[[Int]], _ arr2:[[Int]]) -> [[Int]] {
//    var answer : [[Int]] = []
//
//    for (idx, arr) in arr1.enumerated() {
//        answer.append(zip(arr1[idx], arr2[idx]).map(+))
//    }
//    return answer
    return zip(arr1, arr2).map{zip($0, $1).map(+)}
}

// 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/12950
