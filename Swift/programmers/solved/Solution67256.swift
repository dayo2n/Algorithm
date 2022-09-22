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
  
  var result = ""
  var leftHand = 10
  var rightHand = 12
  
  for i in numbers {
    let number = i == 0 ? 11 : i
    var tapHand: KeypadHand = .left
    
    switch number {
    case 1, 4, 7:
      tapHand = .left
      
    case 3, 6, 9:
      tapHand = .right
      
    case 2, 5, 8, 11:
      let leftTemp = (number - leftHand).magnitude
      let rightTemp = (number - rightHand).magnitude
      
      let leftDistance = (leftTemp / 3) + (leftTemp % 3)
      let rightDistance = (rightTemp / 3) + (rightTemp % 3)
      
      if leftDistance == rightDistance {
        tapHand = hand == "left" ? .left : .right
      } else {  // 그 외
        tapHand = leftDistance < rightDistance ? .left : .right
      }
      
    default:
      break
    }
    
    if tapHand == .left {
      result.append("L")
      leftHand = number
    } else {
      result.append("R")
      rightHand = number
    }
  }
  
  return result
}
print(solution([1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5], "right"))
print(solution([7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2], "left"))
print(solution([1, 2, 3, 4, 5, 6, 7, 8, 9, 0], "right"))

// 출처 : https://school.programmers.co.kr/learn/courses/30/lessons/67256
