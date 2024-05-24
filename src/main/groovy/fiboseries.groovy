//n = 8 --- 0 1 1 2 3 5 8 13
// n = 13
// n = 2
// n = 1

def fibo(n) {
    if (n <= 2) {
        throw new IllegalArgumentException("n must be more than 2")
    }

    def a = 0
    def b = 1
    def result = []

    result << a << b
    for(def i in 2..n-1) {
        def c = a + b
        result << c

        a = b
        b = c
    }

    result
}

