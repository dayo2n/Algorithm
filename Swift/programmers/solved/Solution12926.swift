func solution(_ s:String, _ n:Int) -> String {
    var answer = ""
    for ss in s {
        if ss == " " {
            answer += " "
        } else if ss.asciiValue! > 64 && ss.asciiValue! < 91 { // uppercase
            if ss.asciiValue! + UInt8(n) > 90 {
                answer += String(UnicodeScalar(64 + ss.asciiValue! + UInt8(n) - 90))
            } else {
                answer += String(UnicodeScalar(ss.asciiValue! + UInt8(n)))
            }
        } else { // lowercase
            if ss.asciiValue! + UInt8(n) > 122 {
                answer += String(UnicodeScalar(96 + ss.asciiValue! + UInt8(n) - 122))
            } else {
                answer += String(UnicodeScalar(ss.asciiValue! + UInt8(n)))
            }
        }
    }
    return answer
}
