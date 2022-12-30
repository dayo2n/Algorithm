
// [출처: BOJ] https://www.acmicpc.net/problem/9935

import Foundation
let words: String = readLine()!
let explosion: String = readLine()!

var stack: [String] = []

for word in words {
    stack.append(String(word))
    
    if word == explosion.last! {
        if stack.count >= explosion.count {
            if stack[(stack.count - explosion.count)...].joined() == explosion {
                for _ in 0..<explosion.count {
                    stack.removeLast()
                }
            }
        }
    }
}

print(stack.count == 0 ? "FRULA" : stack.joined())


/*
 48%에서 시간초과난 해결 방법
 : replacingOccurrences 메소드를 폭발 문자열이 없을 때까지 반복해서 삭제
 */

/*
 
 import Foundation
 var words: String = readLine()!
 let explosion: String = readLine()!

 while words.contains(explosion) {
     words = words.replacingOccurrences(of: explosion, with: "")
 }

 print(words.count == 0 ? "FRULA" : words)

 */
