
// [출처: BOJ] https://www.acmicpc.net/problem/1269

var number: [String] = readLine()!.split(separator: " ").map{String($0)}
var numberA: Int = Int(number[0])!
var numberB: Int = Int(number[1])!

var A: Set = Set<Int>()
var B: Set = Set<Int>()

var input: [Int] = readLine()!.split(separator: " ").map{Int($0)!}

for index in 0..<numberA {
    A.insert(input[index])
}

input = readLine()!.split(separator: " ").map{Int($0)!}
for index in 0..<numberB {
    B.insert(input[index])
}

var symmetry: [Int] = []
symmetry.insert(contentsOf: A.subtracting(B), at: 0)
symmetry.insert(contentsOf: B.subtracting(A), at: 0)
print(Set(symmetry).count)
