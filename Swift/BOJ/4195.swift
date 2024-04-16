
// [출처: BOJ] https://www.acmicpc.net/problem/4195
/*
분리집합 union&find
 */

let testcase = Int(readLine()!)!

for _ in 0..<testcase {
    
    let relationships = Int(readLine()!)!
    var parent = [String: String]()
    var count = [String: Int]()
    
    func findRoot(_ name: String) -> String {
        if parent[name] == name {
            return name
        }
        /*
         여기서 parent를 Root로 바꿔줌
         */
        let root = findRoot(parent[name]!)
        parent[name] = root
        return findRoot(parent[name]!)
    }

    func union(_ first: String, _ second: String) {
        let parentFirst = findRoot(first), parentSecond = findRoot(second)
        
        if parentFirst != parentSecond {
            parent[parentSecond] = parentFirst
            count[parentFirst]! += count[parentSecond]!
        }
    }
    
    for _ in 0..<relationships {
        let names = readLine()!.split(separator: " ").map { String($0) }
        let first = names[0], second = names[1]
        if parent[first] == nil {
            parent[first] = first
            count[first] = 1
        }
        if parent[second] == nil {
            parent[second] = second
            count[second] = 1
        }
        
        union(first, second)
        print(count[findRoot(first)]!)
    }
}
