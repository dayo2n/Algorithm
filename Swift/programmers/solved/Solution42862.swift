import Foundation

func solution(_ n:Int, _ lost:[Int], _ reserve:[Int]) -> Int {
    var curReserve: [Int] = reserve.sorted()
    var curLost:[Int] = lost.sorted()
    
    for student in curLost {
        if curReserve.contains(student) {
            curReserve.remove(at: curReserve.index(of: student)!)
            curLost.remove(at: curLost.index(of: student)!)
        }
    }
    
    var students: Int = n - curLost.count
    for student in curLost {
        if curReserve.contains(student) {
            students += 1
            curReserve.remove(at: curReserve.index(of: student)!)
        } else if curReserve.contains(student - 1) {
            students += 1
            curReserve.remove(at: curReserve.index(of: student - 1)!)
        } else if curReserve.contains(student + 1) {
            students += 1
            curReserve.remove(at: curReserve.index(of: student + 1)!)
        }
    }
    return students
}
