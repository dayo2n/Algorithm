func solution(_ s:String) -> String {
    return s.sorted(by: >).map{return String($0)}.reduce("",+)
}
