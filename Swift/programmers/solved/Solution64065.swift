// [출처: 프로그래머스] https://school.programmers.co.kr/learn/courses/30/lessons/64065
import Foundation

func solution(_ s:String) -> [Int] {
    let trimmedTuple = s.split(separator: "}").map{$0.replacingOccurrences(of:"{", with:"")}.map{$0.trimmingCharacters(in: [","])}
    var count: [String: Int] = [:]
    for tuple in trimmedTuple {
        let elements = tuple.split(separator: ",")
        for element in elements {
            if let _ = count[String(element)] {
                count[String(element)]! += 1
            } else { count[String(element)] = 1 }
        }
    }
    return count.sorted{return $0.1 > $1.1}.map{Int($0.0)!}
}
