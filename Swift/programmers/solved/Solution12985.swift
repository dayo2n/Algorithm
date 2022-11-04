import Foundation

func solution(_ n:Int, _ a:Int, _ b:Int) -> Int
{
    var targetA: Int = a
    var targetB: Int = b
    var round: Int = 1
    while true {
        targetA = targetA / 2 + targetA % 2
        targetB = targetB / 2 + targetB % 2
        if targetA == targetB { return round }
        round += 1
    }

    return round
}
