
// [출처: BOJ] https://www.acmicpc.net/problem/2744

let words: String = readLine()!

words.forEach { word in
    if word.isLowercase {
        print(word.uppercased(), terminator: "")
    } else { print(word.lowercased(), terminator: "") }
 }
