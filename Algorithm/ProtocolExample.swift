////
////  ProtocolExample.swift
////  Algorithm
////
////  Created by 제나 on 10/9/23.
////
//
//import Foundation
//protocol RandomNumberGenerator {
//    func random() -> Double
//}
//
//class LinearCongruentialGenerator: RandomNumberGenerator {
//    var lastRandom = 42.0
//    let m = 139968.0
//    let a = 3877.0
//    let c = 29573.0
//    func random() -> Double {
//        lastRandom = ((lastRandom * a + c).truncatingRemainder(dividingBy:m))
//        return lastRandom / m
//    }
//}
//
//class Dice {
//    let sides: Int
//    let generator: RandomNumberGenerator
//    init(sides: Int, generator: RandomNumberGenerator) {
//        self.sides = sides
//        self.generator = generator
//    }
//    func roll() -> Int {
//        return Int(generator.random() * Double(sides)) + 1
//    }
//}
//
//protocol DiceGame {
//    var dice: Dice { get }
//    func play()
//}
//
///// DiceGame의 책임을 DiceGameDelegate를 따르는 인스턴스에 위임
//protocol DiceGameDelegate: AnyObject { // AnyObject로 선언하면 클래스만 이 프로토콜을 채택할 수 있는 속성이 된다.
//    func gameDidStart(_ game: DiceGame)
//    func game(_ game: DiceGame, didStartNewTurnWithDiceRoll diceRoll: Int)
//    func gameDidEnd(_ game: DiceGame)
//}
//
//class SnakesAndLadders: DiceGame { // 프로토콜의 조건에 맞추기위해 dice라는 프로퍼티는 gettable하게 구현되어 있고, play()메소드가 구현되어 있다.
//    let finalSquare = 25
//    let dice = Dice(sides: 6, generator: LinearCongruentialGenerator())
//    var square = 0
//    var board: [Int]
//    init() {
//        board = Array(repeating: 0, count: finalSquare + 1)
//        board[03] = +08; board[06] = +11; board[09] = +09; board[10] = +02
//        board[14] = -10; board[19] = -11; board[22] = -02; board[24] = -08
//    }
//    // 강한 참조 순환을 막기위해 약한 참조를 함
//    weak var delegate: DiceGameDelegate? // 게임 진행에 반드시 필요한 것은 아니기 때문에 옵셔널로 정의
//    /// 게임의 전체 로직이 들어있는 메소드
//    func play() { // 바로 위에 정의한 delegate가 DiceGameDelegation 옵셔널타입이므로 play() 메소드는 delegate의 메소드를 호출할때마다 옵셔널 체이닝을 한다.
//        square = 0
//        /// DiceGameDelegation의 게임 진행상황을 tracking하는 메소드(게임 시작)
//        delegate?.gameDidStart(self)
//        gameLoop: while square != finalSquare {
//            let diceRoll = dice.roll()
//            print(diceRoll)
//            /// DiceGameDelegation의 게임 진행상황을 tracking하는 메소드(게임 진행)
//            delegate?.game(self, didStartNewTurnWithDiceRoll: diceRoll)
//            switch square + diceRoll {
//            case finalSquare:
//                break gameLoop
//            case let newSquare where newSquare > finalSquare:
//                continue gameLoop
//            default:
//                square += diceRoll
//                square += board[square]
//            }
//        }
//        /// DiceGameDelegation의 게임 진행상황을 tracking하는 메소드(게임 종료)
//        delegate?.gameDidEnd(self)
//    }
//}
//
//class DiceGameTracker: DiceGameDelegate { // 프로토콜의 조건에 맞추기위해 3개의 메소드가 구현되어 있다.
//    var numberOfTurns = 0
//    func gameDidStart(_ game: DiceGame) {
//        numberOfTurns = 0
//        if game is SnakesAndLadders { // SnakesAndLadders 클래스의 인스턴스가 매개변수로 들어오면 실행
//            print("Started a new game of Snakes and Ladders")
//        }
//        print("The game is using a \(game.dice.sides)-sided dice")
//    }
//    func game(_ game: DiceGame, didStartNewTurnWithDiceRoll diceRoll: Int) {
//        numberOfTurns += 1
//        print("Rolled a \(diceRoll)")
//    }
//    func gameDidEnd(_ game: DiceGame) {
//        print("The game lasted for \(numberOfTurns) turns")
//    }
//}
//
//let tracker = DiceGameTracker()
//let game = SnakesAndLadders()
//game.delegate = tracker
//game.play()
