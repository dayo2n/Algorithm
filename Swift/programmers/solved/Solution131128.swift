// 실패: 시간초과
import Foundation

func solution(_ X:String, _ Y:String) -> String {
    var currentY: String = Y
    var partner: [Int] = []
    for x in X {
        if currentY.contains(x) {
            partner.append(Int(String(x))!)
            currentY.remove(at: currentY.firstIndex(of: x)!)
        }
    }
    if partner.count == 0 { return "-1" }
    partner = partner.sorted(by: >)
    return partner[0] == 0 ? "0" : partner.map{String($0)}.joined()
}


// 성공: Dictionary 이용

import Foundation
func getDictionary(_ input: String) -> [String: Int] {
    var Dict: [String: Int] = [:]
    input.forEach { item in
           let str: String = String(item)
           if let value = Dict[str] {
               Dict[str] = value + 1
           } else { Dict[str] = 1 }
        }
    return Dict
}

func solution(_ X:String, _ Y:String) -> String {
    
    var DictX: [String: Int] = getDictionary(X)
    var DictY: [String: Int] = getDictionary(Y)
    
    var partner: [Int] = []
    for (key, value) in DictX {
        if let val = DictY[key] {
            for _ in 0..<min(val, value) { partner.append(Int(key)!) }
        }
    }
    
    if partner.count == 0 { return "-1" }
    partner = partner.sorted(by: >)
    return partner[0] == 0 ? "0" : partner.map{String($0)}.joined()
}
