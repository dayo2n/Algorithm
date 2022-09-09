import Foundation

func solution(_ a:[Int], _ b:[Int]) -> Int {
    return zip(a, b).map(*).reduce(0,+)
}
