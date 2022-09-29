import Foundation

// stages.count : 사용자 수
// N : 스테이지 수

func solution(_ N:Int, _ stages:[Int]) -> [Int] {
    var failure: [Int: Double] = [:]
    for n in (0..<N) {
        var user = Double(stages.filter{$0>n}.count) // 도전한 유저
        var challenger = Double(stages.filter{$0==(n+1)}.count) // 아직 클리어하지 못한 유저
        
        if user == 0 {  failure[n] = 0.0 }
        else { failure[n] = challenger / user }
    }
    print(failure.sorted{return $0.value<$1.value})
    return []
}
