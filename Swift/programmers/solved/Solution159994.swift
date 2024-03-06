import Foundation

func solution(_ cards1:[String], _ cards2:[String], _ goal:[String]) -> String {
    var pointer = (0, 0)
    for word in goal {
        if pointer.0 < cards1.count, word == cards1[pointer.0] {
            pointer.0 += 1
        } else if pointer.1 < cards2.count, word == cards2[pointer.1] {
            pointer.1 += 1
        }  else {
            return "No"
        }
    }
    return "Yes"
}
