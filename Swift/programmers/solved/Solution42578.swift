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


// 여러 함수를 이용 => 시간은 더 오래 걸린다 ..
import Foundation

func solution(_ clothes:[[String]]) -> Int {
    var categories = Set(clothes.compactMap({$0.last})).map({ category in
        return clothes.filter({ $0.last == category}).count + 1
    })
    return categories.reduce(1,*) - 1
}
