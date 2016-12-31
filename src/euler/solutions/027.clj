(ns euler.solutions.027
  "Considering quadratics of the form:

  n^2+an+b, where |a|<1000 and |b|≤1000

  where |n| is the modulus/absolute value of n
  e.g. |11|=11 and |−4|=4

  Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n=0."
  (:require [clojure.math.numeric-tower :refer [expt]])
  (:require [euler.math.primes :refer [primes]]) )

(defn quadratic [n a b]
  (-> (expt n 2)
      (+ (* n a))
      (+ b)) )

(def max-prime (quadratic 1000 999 1000))
(def prime-nums (set (primes max-prime)))
(defn prime? [n] (contains? prime-nums n))

(def cpfq  ; Consecutive primes for quadratic
  (for [a (range -999 1000)
        b (range -1000 1001)]
    (loop [n 0]
      (if (prime? (quadratic n a b))
        (recur (inc n))
        (hash-map :a a :b b :n n) ))))

(->> cpfq
     (apply max-key :n)
     (#(* (% :a) (% :b)))
     (println "Solution 027:")
     (time))
