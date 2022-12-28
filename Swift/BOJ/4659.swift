
// [출처: BOJ] https://www.acmicpc.net/problem/4659


while true {
    let vowels: [String] = ["a", "e", "i", "o", "u"]
    let words: String = readLine()!
    var printed: Bool = false
    
    if words == "end" { break } // end가 나오면 끝
    
    // 1. 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
    if words.filter{ vowels.contains(String($0)) }.count == 0 {
        print("<\(words)> is not acceptable.")
        printed = true
    }
    
    // 2. 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
    // 3. 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
    var consonantCnt: Int = 0
    var vowelCnt: Int = 0
    var prevWord: String? = nil
    for word in words {
        if let _ = prevWord {
            if prevWord == String(word) {
                if prevWord == "e" || prevWord == "o" { continue }
                else {
                    if !printed { print("<\(words)> is not acceptable.") }
                    printed = true
                    break
                }
            }
        }
        prevWord = String(word)
        if vowels.contains(String(word)) {
            consonantCnt = 0
            vowelCnt += 1
        } else {
            vowelCnt = 0
            consonantCnt += 1
        }
        if vowelCnt > 2 || consonantCnt > 2 {
            if !printed { print("<\(words)> is not acceptable.") }
            printed = true
            break
        }
    }
    
    if !printed { print("<\(words)> is acceptable.") }
}
