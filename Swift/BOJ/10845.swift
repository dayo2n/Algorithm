
// [출처: BOJ] https://www.acmicpc.net/problem/10845

struct Queue {
    var queue: [Int]
    
    init() {
        queue = []
    }
    
    mutating func push(_ x: Int) {
        queue.append(x)
    }
    
    mutating func pop() {
        if queue.isEmpty {
            print(-1)
        } else {
            print(queue.removeFirst())
        }
    }
    
    func size() {
        print(queue.count)
    }
    
    func empty() {
        print(queue.isEmpty ? 1 : 0)
    }
    
    func front() {
        if let first = queue.first {
            print(first)
        } else {
            print(-1)
        }
    }
    
    func back() {
        if let last = queue.last {
            print(last)
        } else {
            print(-1)
        }
    }
}

enum Command: String {
    case push
    case pop
    case size
    case empty
    case front
    case back
}

var queue = Queue()
let n = Int(readLine()!)!
for _ in 0..<n {
    let input = readLine()!.split(separator: " ")
    let command = Command(rawValue: String(input[0]))!
    
    switch command {
    case .push:
        let value = Int(input[1])!
        queue.push(value)
    case .pop:
        queue.pop()
    case .size:
        queue.size()
    case .empty:
        queue.empty()
    case .front:
        queue.front()
    case .back:
        queue.back()
    }
}
