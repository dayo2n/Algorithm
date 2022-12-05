// [출처: 프로그래머스] https://school.programmers.co.kr/learn/courses/30/lessons/42579

import Foundation

func solution(_ genres:[String], _ plays:[Int]) -> [Int] {
    var byGenre: [String: Int] = [:] // 장르별 속한 노래 재생 횟수
    var byMusic: [String: [Int]] = [:] // 장르별로 많이 재생된 노래 두 곡의 고유번호
    
    for (index, genre) in genres.enumerated() {
        if let _ = byGenre[genre] { byGenre[genre]! += plays[index] }
        else { byGenre[genre] = plays[index] }
        
        if let _ = byMusic[genre] {
            byMusic[genre]!.append(index)
            if byMusic[genre]!.count >= 2 { byMusic[genre] = byMusic[genre]!.sorted{ plays[$0] > plays[$1] }}
            if byMusic[genre]!.count > 2 { byMusic[genre]!.popLast() }
        }
        else { byMusic[genre] = [index] }
    }
    var playlist: [Int] = []
    byGenre.sorted{$0.value > $1.value}.map{playlist.append(contentsOf: byMusic[$0.key]!)}
    return playlist
}
