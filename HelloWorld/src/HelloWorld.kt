fun main() {
    println(highFunc({ x, y -> x + y }, 10, 20)) // 람다식 함수를 인자로 넘김
}

 fun highFunc(sum: (Int, Int) -> Int, a: Int, b: Int)= sum(a, b) // sum 매개변수는 함수
