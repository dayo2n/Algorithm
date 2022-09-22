func solution(_ phone_number:String) -> String {
//     return Array(repeating: "*", count: phone_number.count - 4).reduce("",+) + phone_number[phone_number.index(phone_number.startIndex, offsetBy: phone_number.count - 4)..<phone_number.endIndex]
    return "\(String(repeating: "*", count: phone_number.count - 4))\(phone_number.suffix(4))"
}

// 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/12948
