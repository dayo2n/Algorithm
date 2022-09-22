func solution(_ s:String) -> String {
    
    var answer = ""
    var index = 0
    
    for char in s {
        if char == " " {
            index = 0
            answer.append(" ")
            continue
        }
        answer.append(index % 2 == 0 ? char.uppercased() : char.lowercased())
        index = index + 1
    }
    return answer
}

// 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/12930
