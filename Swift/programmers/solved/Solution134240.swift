import Foundation

func solution(_ food:[Int]) -> String {
    var placement: String = ""
    for index in 1..<food.count {
        placement.append(String(repeating: "\(index)", count: food[index]/2))
    }
    return "\(placement)0\(String(placement.reversed()))"
}
