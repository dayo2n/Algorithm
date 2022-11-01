func gcd(_ a: Int, _ b: Int) -> Int {
    var r: Int
    var x: Int = a
    var y: Int = b
    while y > 0 {
        r = x % y
        x = y
        y = r
    }
    return x
}

func lcm(_ a: Int, _ b: Int) -> Int {
    return a * b / gcd(a, b)
}

func solution(_ arr:[Int]) -> Int {
    var result: Int = arr[0]
    for index in stride(from: 1, to: arr.count, by: 1) {
        result = lcm(result, arr[index])
    }
    return result
}
