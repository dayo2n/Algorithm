func solution(_ phone_number:String) -> String {
     return Array(repeating: "*", count: phone_number.count - 4).reduce("",+) + phone_number[phone_number.index(phone_number.startIndex, offsetBy: phone_number.count - 4)..<phone_number.endIndex]
}
