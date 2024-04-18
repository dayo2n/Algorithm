
// [출처: BOJ] https://www.acmicpc.net/problem/1647
/*
 최소 스패닝 트리
 readLine으로 입력받으면 시간초과남
 */
import Foundation
final class FileIO {
    private var buffer:[UInt8]
    private var index: Int
    
    init(fileHandle: FileHandle = FileHandle.standardInput) {
        buffer = Array(fileHandle.readDataToEndOfFile())+[UInt8(0)]
        index = 0
    }
    
    @inline(__always) private func read() -> UInt8 {
        defer { index += 1 }
        return buffer.withUnsafeBufferPointer { $0[index] }
    }
    
    @inline(__always) func readInt() -> Int {
        var sum = 0
        var now = read()
        var isPositive = true
        
        while now == 10 || now == 32 { now = read() }
        if now == 45{ isPositive.toggle(); now = read() }
        while now >= 48, now <= 57 {
            sum = sum * 10 + Int(now-48)
            now = read()
        }
        return sum * (isPositive ? 1 : -1)
    }
}

let file = FileIO()

let N = file.readInt() // # home
let M = file.readInt() // # road

var costs = [Int](0...N)

var mst = [(from: Int, to: Int, cost: Int)]()
for _ in 0..<M {
    let (computerA, computerB, cost) = (file.readInt(), file.readInt(), file.readInt())
    if computerA != computerB {
        mst.append((computerA, computerB, cost))
    }
}

mst.sort(by: { $0.cost < $1.cost })
var total = 0
var maxTotal = 0
for element in mst {
    let from = element.from, to = element.to, cost = element.cost
    if findRoot(from) != findRoot(to) {
        union(from, to)
        total += cost
        maxTotal = max(maxTotal, cost)
    }
}

print(total - maxTotal)

func union(_ a: Int, _ b: Int) {
    let rootA = findRoot(a), rootB = findRoot(b)
    if rootA != rootB {
        costs[rootB] = rootA
    }
}

func findRoot(_ x: Int) -> Int {
    if x == costs[x] {
        return x
    }
    costs[x] = findRoot(costs[x])
    return costs[x]
}
