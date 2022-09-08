func solution(_ n:Int) -> String {
    if n == 1 { return "수"}
    return n % 2 == 0 ? String(repeating: "수박", count: n/2) : "\(String(repeating: "수박", count: n/2))수"
}
