import Foundation

func evaluateExpression(_ expression: [String]) -> Int {
    var result = 0
    var currentOperator = "+"
    var currentOperand = 0
    
    for token in expression {
        if let number = Int(token) {
            switch currentOperator {
            case "+":
                currentOperand += number
            case "-":
                currentOperand -= number
            default:
                break
            }
        } else if token == "+" || token == "-" {
            currentOperator = token
        } else if token == "(" {
            var matchingIndex = 0
            var bracketCounter = 1
            for (index, element) in expression.enumerated() {
                if element == "(" {
                    bracketCounter += 1
                } else if element == ")" {
                    bracketCounter -= 1
                    if bracketCounter == 0 {
                        matchingIndex = index
                        break
                    }
                }
            }
            
            let subExpression = Array(expression[(expression.index(after: expression.startIndex) + 1)..<expression.index(expression.startIndex, offsetBy: matchingIndex)])
            currentOperand += evaluateExpression(subExpression)
            continue
        }
    }
    
    result = currentOperand
    return result
}

func getAllPossibleResults(_ expression: [String]) -> [Int] {
    var results = [Int]()
    
    for (index, token) in expression.enumerated() {
        if token == "(" {
            var matchingIndex = 0
            var bracketCounter = 1
            for (i, element) in expression[(index + 1)...].enumerated() {
                if element == "(" {
                    bracketCounter += 1
                } else if element == ")" {
                    bracketCounter -= 1
                    if bracketCounter == 0 {
                        matchingIndex = i
                        break
                    }
                }
            }
            
            let subExpression = Array(expression[(index + 1)..<matchingIndex + index + 1])
            var modifiedExpression = expression
            modifiedExpression.replaceSubrange(index...matchingIndex + index, with: ["\(evaluateExpression(subExpression))"])
            let subResults = getAllPossibleResults(modifiedExpression)
            results.append(contentsOf: subResults)
        }
    }
    
    return results
}

func printAllPossibleResults(_ expression: [String]) -> [Int] {
    let results = getAllPossibleResults(expression)
    for result in results {
        print(result)
    }
    return results
}


let expression = ["1", "-", "5", "-", "3"]
printAllPossibleResults(expression)
