func solution(_ s:String) -> String {
    var isFirst: Bool = true
    // var isBlank: Bool = false
    var newString = ""
    
    for word in s {
        if word == " " {
            isFirst = true
            // isBlank = true
            newString += " "
            continue
        }
        newString += isFirst ? String(word).uppercased() : String(word).lowercased()
        isFirst = false
        
    }
    return newString
}
