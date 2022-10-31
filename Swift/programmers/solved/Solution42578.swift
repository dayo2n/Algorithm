import Foundation

func solution(_ clothes:[[String]]) -> Int {
    var categories: [String : Int] = [:]
    for cloth in clothes {
        if let category = categories[cloth[1]] {
            categories[cloth[1]]! += 1
        } else {
            categories[cloth[1]] = 1
        }
    }
    return categories.values.map{$0+1}.reduce(1,*) - 1
}
