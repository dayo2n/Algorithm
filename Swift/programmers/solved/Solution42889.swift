import Foundation

func solution(_ N:Int, _ stages:[Int]) -> [Int] {
    var failure = [(Int, Double)]()
    var user = stages.count
    
    for n in (1...N) {
        // var challenger = stages.filter{$0==n}.count // 아직 클리어하지 못한 유저
        var challenger = 0
        for stage in 0..<stages.count {
            if stages[stage] == n { challenger += 1 }
        }

        failure.append((n, Double(challenger) / Double(user)))
        user -= challenger
    }
    return failure.sorted{$0.1 > $1.1}.map{$0.0}
}

// 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/42889
