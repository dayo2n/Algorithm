import Foundation

func solution(_ brown:Int, _ yellow:Int) -> [Int] {
    var sum: Int = brown + yellow
    
    for curHeight in (3...sum) {
        for curWidth in (3...curHeight) {
            if curHeight * curWidth == sum {
                if (curWidth - 2) * (curHeight - 2) == yellow {
                    return [curHeight, curWidth]
                }
            }
        }
    }
    return []
}
