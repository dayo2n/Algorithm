import Foundation

func solution(_ a:Int, _ b:Int, _ n:Int) -> Int {
    var bonus:Int = 0
    var currentCoke: Int = n
    while currentCoke / a > 0 {
        var getBonus: Int = currentCoke / a * b
        bonus += getBonus
        currentCoke = currentCoke % a + getBonus
    }
    return bonus
}
