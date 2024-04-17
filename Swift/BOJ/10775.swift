
// [출처: BOJ] https://www.acmicpc.net/problem/10775
/*
 아니 이거 분리집합이래서 풀었는데 문제도 이해못했음
 비행기-게이트간 도킹 시스템이 뭐 어떻게 되는데 이렇게 배치하는거야..?
 모름
 이거 푼거아님 ㄹㅇ
 더 강해져서 다시 풀러와라
 */

let totalGate = Int(readLine()!)!
let totalPlane = Int(readLine()!)!
var parent = [Int](0...totalGate)

func find(_ plane: Int) -> Int {
    if plane == parent[plane] {
        return plane
    }
    parent[plane] = find(parent[plane])
    return parent[plane]
}

func union(_ first: Int, _ second: Int) {
    let firstRoot = find(first), secondRoot = find(second)
    parent[secondRoot] = firstRoot
}

for count in 0..<totalPlane {
    let plane = find(Int(readLine()!)!)
    if plane == 0 {
        print(count)
        break
    }
    if count == totalPlane - 1 {
        print(totalPlane)
    }
    union(plane - 1, plane)
}
