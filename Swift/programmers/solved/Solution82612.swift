import Foundation

func solution(_ price:Int, _ money:Int, _ count:Int) -> Int64{
    var answer:Int64 = Int64(Array(1...count).map{$0*price}.reduce(0,+) - money)
    return answer > 0 ? answer : 0
}
