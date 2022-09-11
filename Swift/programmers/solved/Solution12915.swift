func solution(_ strings:[String], _ n:Int) -> [String] {
    return strings.sorted {
        var idx0 = $0.index($0.startIndex, offsetBy: n)
        var idx1 = $1.index($1.startIndex, offsetBy: n)
        if $0[idx0] == $1[idx1] { return $0 < $1 }
        return $0[idx0] < $1[idx1]
    }
}
