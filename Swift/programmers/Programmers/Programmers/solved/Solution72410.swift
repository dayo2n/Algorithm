//
//  main.swift
//  Programmers
//
//  Created by 문다 on 2022/05/21.
//

import Foundation

//print("Hello, World!")

//var input = readLine()
//
//if let input = input {
//    print("input : \(input)")
//}


// Reading an Int
//var inputInt = Int(readLine()!)!
//print(inputInt)

func solution(_ new_id:String) -> String {
    
    // 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
    var id : String = new_id.lowercased()
    
    // 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
//    let pattern : Set<Character> = ["-", "_", ".", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"]
//    id.removeAll(where: { !pattern.contains($0)} )
    
    var newID : String = ""
    for char in id {
        if char.isLetter || char.isNumber || char == "-" || char == "_" || char == "." {
            newID.append(char)
        }
    }
    
    id = newID
    newID = ""
    
    // 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
//    var seq : Bool = false
//    for char in id {
//        if char == "." {
//            if !seq {
//                newID.append(char)
//            }
//            seq = true
//        } else {
//            newID.append(char)
//            seq = false
//        }
//    }
//  id = newID
    
    while id.contains("..") {
        id = id.replacingOccurrences(of: "..", with: ".")
    }
    
    
//    4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
    if id.first == "." {
        id.removeFirst()
    }
    
    if id.last == "." {
        id.removeLast()
    }
    
//    5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
    if id == "" {
        id = "a"
    }
    
//    6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//         만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
    if id.count > 15 {
        id = String(id[id.startIndex ..< id.index(id.startIndex, offsetBy: 15)])
        if id.last == "." {
            id.removeLast()
        }
    }
    
//    7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
    while id.count < 3 {
        id.append(id[id.index(id.startIndex, offsetBy: id.count-1)])
    }
    
    return id
}

print(solution("...!@BaT#*..y.abcdefghijklm")) // bat.y.abcdefghi
print(solution("z-+.^.")) // z--
print(solution("=.=")) // aaa
print(solution("123_.def")) // 123_.def
print(solution("abcdefghijklmn.p")) // abcdefghijklmn
