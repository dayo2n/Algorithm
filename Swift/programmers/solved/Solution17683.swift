// [출처: 프로그래머스] https://school.programmers.co.kr/learn/courses/30/lessons/17683

func getPlayTime(_ from: String, _ to: String) -> Int {
    let splitFrom = from.split(separator: ":").map{Int(String($0))!}
    let splitTo = to.split(separator: ":").map{Int(String($0))!}
    if splitFrom[0] < splitTo[0] {
        var diffTime: Int = 0
        if splitFrom[1] > splitTo[1] {
            diffTime = (splitTo[0] - splitFrom[0] - 1) * 60 + (60 + splitTo[1] - splitFrom[1])
        } else { diffTime = (splitTo[0] - splitFrom[0]) * 60 + (splitTo[1] - splitFrom[1]) }
        if diffTime > 1440 { return 1440 }
        return diffTime
    } else { // splitFrom[0] == splitTo[0]
        return splitTo[1] - splitFrom[1]
    }
    return 0
}

func solution(_ m:String, _ musicinfos:[String]) -> String {
    var candiTitle: String = "(None)"
    var candiLen: Int = -1
    let hashMelody: [String: String] = ["C#": "c", "D#": "d", "F#": "f", "G#": "g", "A#": "a"]
    var neo: String = m

    for hash in hashMelody.keys { neo = neo.replacingOccurrences(of: hash, with: hashMelody[hash]!) }
    
    for info in musicinfos {
        let splitInfo = info.split(separator: ",").map{String($0)}
        let playTime: Int = getPlayTime(splitInfo[0], splitInfo[1])
        let title: String = splitInfo[2]
        var melody: String = splitInfo[3]
        // #을 다른 문자로 치환
        for hash in hashMelody.keys {
            melody = melody.replacingOccurrences(of: hash, with: hashMelody[hash]!)
        }
        // 재생된 길이만큼 문자열을 나열 (최대 1400개)
        var melodyLen: Int = melody.count
        var tmp = String(repeating: melody, count: playTime / melodyLen) + melody[melody.startIndex..<melody.index(melody.startIndex, offsetBy: playTime % melodyLen)]

        if tmp.contains(neo) && tmp.count > candiLen {
            candiTitle = title
            candiLen = tmp.count
        }
    }
    return candiTitle
}
