
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
