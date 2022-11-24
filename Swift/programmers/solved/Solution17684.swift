
// [출처: 프로그래머스] https://school.programmers.co.kr/learn/courses/30/lessons/17684

func solution(_ msg:String) -> [Int] {
    var maxLen: Int = 1
    // A~Z
    var letters: [String] = ["A", "B", "C", "D", "E",
                             "F", "G", "H", "I", "J",
                             "K", "L", "M", "N", "O",
                             "P", "Q", "R", "S", "T",
                             "U", "V", "W", "X", "Y", "Z"]
    var cursor: Int = 0
    var answer: [Int] = []
    
    while cursor < msg.count {
        var w: String = ""
        
        // 긴 문자열부터 검색
        for index in stride(from: (cursor+maxLen > msg.count) ? msg.count-1 : cursor+maxLen-1, to: cursor-1, by: -1) {
            w = String(msg[msg.index(msg.startIndex, offsetBy: cursor)...msg.index(msg.startIndex, offsetBy: index)])
            
            // 찾으면 정답배열에 색인 추가, 커서옮기고 그 다음 문자붙여서 사전에 추가
            if letters.contains(w) {
                answer.append(letters.firstIndex(of: w)!+1)
                cursor += w.count
                if cursor < msg.count {
                letters.append(w + String(msg[msg.index(msg.startIndex, offsetBy: index+1)]))
                if w.count + 1 > maxLen { maxLen = w.count + 1 }
                }
                break
            }
        }
    }
    return answer
}
