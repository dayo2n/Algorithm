func solution(_ n: Int, _ t: Int, _ m: Int, _ p: Int) -> String {
    var prepared = [String]()
    var currentNumber = 0
    var order = 1
    var result = ""
    while prepared.count < t * m || result.count < t {
        let converted = String(currentNumber, radix: n)
        for word in Array(converted) {
            let word = String(word)
            prepared.append(word)
            if order == p,
            result.count < t {
                result += word
            }
            if result.count >= t { break }
            order = order == m ? 1 : order + 1
        }
        currentNumber += 1
    }
    return result.uppercased()
}
