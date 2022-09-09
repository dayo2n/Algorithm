func solution(_ s:String) -> String {
    return s[s.index(s.startIndex, offsetBy: s.count / 2)] + (s.count % 2 == 0 ? String(s[s.index(s.startIndex, offsetBy: s.count / 2 + 1)]) : "")
}
