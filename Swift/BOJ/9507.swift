
// [출처: BOJ] https://www.acmicpc.net/problem/9507
let t: Int = Int(readLine()!)!

var koong: [Int] = []
koong.append(1) // [0]
koong.append(1) // [1]
koong.append(2) // [2]
koong.append(4) // [3]


for _ in 0..<t {
    let n: Int = Int(readLine()!)!
    if koong.count <= n {
        for index in koong.count...n {
            koong.append(koong[index-1] + koong[index-2] + koong[index-3] + koong[index-4])
        }
    }
    print(koong[n])
}
