import Foundation

func solution(_ name:[String], _ yearning:[Int], _ photo:[[String]]) -> [Int] {
    var informations = [String: Int]()
    for index in 0..<name.count {
        informations[name[index]] = yearning[index]
    }
    
    var totals = [Int]()
    for eachPhoto in photo {
        var sum = 0
        for person in eachPhoto {
            if let score = informations[person] {
                sum += score
            }
        }
        totals.append(sum)
    }
    return totals
}
