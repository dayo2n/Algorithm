
// [출처: 프로그래머스] https://school.programmers.co.kr/learn/courses/30/lessons/17677

var result1: [String: Int] = [:] // [원소: 중복 원소의 수]
var result2: [String: Int] = [:]

func getEachSet(_ inputStr: String, _ which: Int) {
    for (index, str) in inputStr.enumerated() {
        if index == inputStr.count - 1 { break }
        if !str.isLetter || str.isWhitespace { continue }
        let next = inputStr[inputStr.index(inputStr.startIndex, offsetBy: index+1)]
        if !next.isLetter || next.isWhitespace { continue }
        
        let item = (String(str)+String(next)).lowercased()
        if which == 1 {
            if let _ = result1[item] {
                result1[item]! += 1
            } else { result1[item] = 1 }
        } else {
            if let _ = result2[item] {
                result2[item]! += 1
            } else { result2[item] = 1 }
        }
    }
}
func solution(_ str1:String, _ str2:String) -> Int {
    getEachSet(str1, 1)
    getEachSet(str2, 2)
    
    var union: Int = 0 // union
    var intersection: Int = 0 // intersection
    
    for result in result1 {
        if let _ = result2[result.key] {
            union += max(result.value, result2[result.key]!)
            intersection += min(result.value, result2[result.key]!)
            result2[result.key] = nil // result2에서는 지워버림
        } else { union += result.value }
    }
    // result2에 남은거 다 담으면 됨
    for result in result2 { union += result.value }
    
    var jaccard: Double = 0.0
    if union == 0 && intersection == 0 { jaccard = 1.0 }
    else { jaccard = Double(intersection) / Double(union) }
    return Int(jaccard * 65536)
}
