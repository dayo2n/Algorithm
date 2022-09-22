func solution(_ strings:[String], _ n:Int) -> [String] {
//    return strings.sorted {
//        var idx0 = $0.index($0.startIndex, offsetBy: n)
//        var idx1 = $1.index($1.startIndex, offsetBy: n)
//        if $0[idx0] == $1[idx1] { return $0 < $1 }
//        return $0[idx0] < $1[idx1]
//    }
    return strings.sorted {
        return Array($0)[n] == Array($1)[n] ? $0 < $1 : Array($0)[n] < Array($1)[n]
    }
}

// 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/12915
