//func solution(_ s:String, _ n:Int) -> String {
//    var answer = ""
//    for ss in s {
//        if ss == " " {
//            answer += " "
//        } else if ss.asciiValue! > 64 && ss.asciiValue! < 91 { // uppercase
//            if ss.asciiValue! + UInt8(n) > 90 {
//                answer += String(UnicodeScalar(64 + ss.asciiValue! + UInt8(n) - 90))
//            } else {
//                answer += String(UnicodeScalar(ss.asciiValue! + UInt8(n)))
//            }
//        } else { // lowercase
//            if ss.asciiValue! + UInt8(n) > 122 {
//                answer += String(UnicodeScalar(96 + ss.asciiValue! + UInt8(n) - 122))
//            } else {
//                answer += String(UnicodeScalar(ss.asciiValue! + UInt8(n)))
//            }
//        }
//    }
//    return answer
//}

func solution(_ s:String, _ n:Int) -> String {
    return s.utf8.map {
        var code = Int($0)
        
        switch(code) {
            case 65...90:
                code = (code + n - 65) % 26 + 65
            case 97...122:
                code = (code + n - 97) % 26 + 97
            default:
                break
        }
        return String(UnicodeScalar(code)!)
    }.joined()
}
