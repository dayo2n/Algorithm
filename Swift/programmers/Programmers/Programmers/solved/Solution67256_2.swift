//
//  main.swift
//  Programmers
//
//  Created by 문다 on 2022/05/21.
//
import Foundation

func solution(_ numbers:[Int], _ hand:String) -> String {
    
    enum KeypadHand {
        case left
        case right
      }
    
    var answer : String = ""
    var currentLeft : Int = 10 // *
    var currentRight : Int = 12 // #
    
    for number in numbers {
        
        let target = number == 0 ? 11 : number // 키패드 숫자가 0일 경우 11로 바꿔준다
        var tapHand: KeypadHand = .left // 사용한 손을 저장할 변수 선언
        
        switch target {
            
        case 1, 4, 7:
            tapHand = .left
            
        case 3, 6, 9:
            tapHand = .right
            
        case 2, 5, 8, 11:
            let leftTemp = (target - currentLeft).magnitude
            let rightTemp = (target - currentRight).magnitude
              
          let leftDistance = (leftTemp / 3) + (leftTemp % 3)
          let rightDistance = (rightTemp / 3) + (rightTemp % 3)
          
          if leftDistance == rightDistance {
            tapHand = hand == "left" ? .left : .right
          } else {
            tapHand = leftDistance < rightDistance ? .left : .right
          }
            
        default:
            break
        }
        
        if tapHand == .left {
          answer.append("L")
          currentLeft = target
        } else {
          answer.append("R")
          currentRight = target
        }
    }
    
    return answer
}

print(solution([1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5], "right"))
print(solution([7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2], "left"))
print(solution([1, 2, 3, 4, 5, 6, 7, 8, 9, 0], "right"))
