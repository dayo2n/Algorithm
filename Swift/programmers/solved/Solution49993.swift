// [출처: 프로그래머스] https://school.programmers.co.kr/learn/courses/30/lessons/49993
import Foundation

func solution(_ skill:String, _ skill_trees:[String]) -> Int {
    var count: Int = 0
    var order: Int = 0
    var enable: Bool = false
    for tree in skill_trees {
        order = 0
        for curSkill in tree {
            if skill.contains(curSkill) {
                if curSkill == skill[skill.index(skill.startIndex, offsetBy: order)] {
                    order += 1
                }
                else {
                    enable = false
                    break
                }
            }
            enable = true
        }
        if enable { count += 1 }
    }
    return count
}
