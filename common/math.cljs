(ns common.math)

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

(defn prime-factors [number]
  "For a given number, return a vector of the prime factors.
    eg: 18 -> [2 3 3]
    eg: 7 -> [7]
    eg: -4 -> []"
  (loop [quotient number
         divisor 2
         factors []]
    (if (< quotient 2)
      factors
      (if (= 0 (rem quotient divisor))
        (recur (/ quotient divisor) divisor (conj factors divisor))
        (recur quotient (inc divisor) factors) ))))
