
import Foundation

func checkBabbling(_ enable:[String], _ target: String) -> Bool {
    if enable.contains(target) { return true }
    var index: Int = 0
    var flag: Bool = false
    var lastWord: String = ""
    while index < target.count {
        flag = false
        for word in enable {
            if index + word.count > target.count { continue }
            var splitWord = target[target.index(target.startIndex, offsetBy: index)..<target.index(target.startIndex, offsetBy: index+word.count)]
            if  splitWord == word && lastWord != word {
                index += word.count
                flag = true
                lastWord = word
                break
            }
        }
        if !flag { return false }
    }
    return true
}

func solution(_ babbling:[String]) -> Int {
    let enable: [String] = ["aya", "ye", "woo", "ma"]
    return babbling.filter{checkBabbling(enable, $0)}.count
}
