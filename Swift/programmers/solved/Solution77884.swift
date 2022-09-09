import Foundation

func isEven(_ number: Int) -> Bool {
    return Array(1...number).filter{number % $0 == 0}.count % 2 == 0
}

func solution(_ left:Int, _ right:Int) -> Int {
    
    var answer = 0
    for n in (left...right) {
        answer = answer + (isEven(n) ? n : -n)
    }
    return answer
}
