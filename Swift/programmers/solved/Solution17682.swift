import Foundation

func solution(_ dartResult:String) -> Int {
    var score: [Double] = [0.0, 0.0, 0.0]
    
    var round: Int = -1
    var curScore: String = "" // 점수가 두 자리 이상인 경우
    for dart in dartResult {
        if Int(String(dart)) != nil {
            if curScore.isEmpty { round += 1 }
            curScore += String(dart)
        }
        else {
            if !curScore.isEmpty { score[round] = Double(curScore)! }
            switch String(dart) {
                case "S":
                break;
                case "D":
                score[round] = pow(score[round], 2)
                case "T":
                score[round] = pow(score[round], 3)
                case "*":
                for prev in ((round-1 < 0) ? 0 : round-1)...round {
                    score[prev] *= 2
                }
                case "#":
                score[round] *= -1
                default:
                break
            }
            curScore = ""
            print(score)
        }
    }
    return Int(score.reduce(0,+))
}

// Single(S), Double(D), Triple(T)
// 스타상(*): 2배 , 아차상(#): -1배
