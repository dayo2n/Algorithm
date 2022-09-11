func solution(_ n:Int, _ arr1:[Int], _ arr2:[Int]) -> [String] {
    var answer: [String] = []
    
    for (idx, element) in arr1.enumerated() {
        var map1 = String(element, radix: 2)
        map1 = String(repeating: "0", count: n - map1.count) + map1
        var map2 = String(arr2[idx], radix: 2)
        map2 = String(repeating: "0", count: n - map2.count) + map2
        
        answer.append(zip(map1, map2).map{Int(String($0))! + Int(String($1))! > 0 ? "#" : " "}.joined())
        
    }
    return answer
}
