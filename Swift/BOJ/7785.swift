
// [출처: BOJ] https://www.acmicpc.net/problem/7785


// array에서 append, remove를 반복하여 명단을 구하는 방법은 시간 초과
// 딕셔너리를 이용해 bool로 구분하고, 나중에 filter해서 구하는 방법으로 통과 
var n: Int = Int(readLine()!)!
var names: [String:Bool] = [:]

for _ in 0..<n {
    let log: [String] = readLine()!.split(separator: " ").map{String($0)}
    if log[1] == "enter" {
        if let _ = names[log[0]] {
            names[log[0]]! = true
        } else {
            names[log[0]] = true
        }
    } else { // leave
        names[log[0]]! = false
    }
}


for (name, value) in names.filter({ $0.value }).sorted(by: { $0.key > $1.key }) {
    print(name)
}
