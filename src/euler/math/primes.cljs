(ns euler.math.primes)

(defn pow
  "Raise `base` to the power of `exp`
  eg: (pow 2 3) -> 8"
  [base exp]
  (apply * (repeat exp base)) )

(defn factor?
  "Test to see if candidate is a factor of number. Returns a bool.
  eg: (factor? 15 3) -> true
  eg: (factor? 16 3) -> false"
  [number candidate]
  (zero? (mod number candidate)) )

(defn prime-factors [n]
  "For a given number, return a vector of its prime factors
  eg: 18 -> [2 3 3]
  eg: 7 -> [7]
  eg: -4 -> []"
  (loop [quotient n
         divisor 2
         factors []]
    (if (< quotient 2)
      factors
      (if (= 0 (rem quotient divisor))
        (recur (/ quotient divisor) divisor (conj factors divisor))
        (recur quotient (inc divisor) factors) ))))

(defn factors [n]
  "For a given number, return a sorted set of ALL its factors
  eg: 10 -> #{1 2 5 10}
  eg: 28 -> #{1 2 4 7 14 28}"
  (into (sorted-set)
        (reduce concat
                (for [x (range 1 (inc (Math/sqrt n)))
                      :when (zero? (rem n x))]
                  [x (/ n x)]))))

(defn sieve
  "Sieve of Eratosthenes"
  [[xs ps]]
  (let [[p & more] xs]
    [(remove #(zero? (rem % p)) xs) (cons p ps)]))

(defn primes [n]
  "Find all prime numbers less than or equal to n"
  (if (< n 2)
    []
    (->> [(range 2 (inc n)) nil]
         (iterate sieve)
         (drop-while #(< (ffirst %) (Math/sqrt n)))
         first
         (apply concat))))

(defn gcd [a b]
  "Greatest common divisor"
  (if (zero? b)
    a
    (recur b (mod a b))))
