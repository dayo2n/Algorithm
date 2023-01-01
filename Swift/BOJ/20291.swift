
// [출처: BOJ] https://www.acmicpc.net/problem/20291

let N: Int = Int(readLine()!)!

var filename: [String: Int] = [:]

for _ in 0..<N {
    let file: [String] = readLine()!.split(separator: ".").map({String($0)})
    if let _ = filename[file[1]] {
        filename[file[1]]! += 1
    } else {
        filename[file[1]] = 1
    }
}

filename.sorted(by: {$0.key < $1.key}).forEach({ file in
    print("\(file.key) \(file.value)")
})
