//
//  main.swift
//  Programmers
//
//  Created by 문다 on 2022/05/21.
//

import Foundation

func solution(_ s:String) -> Bool
{
    return (s.lowercased().filter{$0=="p"}.count) == (s.lowercased().filter{$0=="y"}.count) ? true : false
}
