
// [출처: BOJ] https://www.acmicpc.net/problem/1004

let T: Int = Int(readLine()!)!

for _ in 0..<T {
    var info: [Int] = readLine()!.split(separator: " ").map{Int($0)!}
    let (x1, y1, x2, y2) = (info[0], info[1], info[2], info[3])
    let n: Int = Int(readLine()!)!
    var answer: Int = 0
    
    for _ in 0..<n {
        info = readLine()!.split(separator: " ").map{Int($0)!}
        let (cx, cy, r) = (info[0], info[1], info[2])
        let R: Int = r * r
        var (inner1, inner2) = (true, true)
        
        var dst: Int = (cx - x1) * (cx - x1) + (cy - y1) * (cy - y1)
        if dst > R { inner1 = false }
        
        dst = (cx - x2) * (cx - x2) + (cy - y2) * (cy - y2)
        if dst > R { inner2 = false }
        
        answer += (inner1 == inner2) ? 0 : 1
    }
    
    print(answer)
}

