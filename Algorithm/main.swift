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
