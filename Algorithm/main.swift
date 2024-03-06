import Foundation
let N = Int(readLine()!)!
if N == 0 {
    exit(0)
}
var result = ""
for _ in 0..<N {
    let input = readLine()!.split(separator: " ")
    let string = input[0]
    let transform = input[1]
    if let index = string.uppercased().firstIndex(of: "X") {
        let distance = string.distance(
            from: string.startIndex,
            to: index
        )
       result += transform[transform.index(transform.startIndex, offsetBy: distance)].uppercased()
    }
}

print(result)
