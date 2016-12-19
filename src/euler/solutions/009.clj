(ns euler.solutions.009
  "A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

  a^2 + b^2 = c^2
  For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.

  There exists exactly one Pythagorean triplet for which a + b + c = 1000.
  Find the product abc."
  (:require [clojure.math.numeric-tower :refer [expt]]))

(defn solution [perimeter]
  (let [max-side-len (quot perimeter 2)]
    (last
      (for [a (range 1 (+ 1 max-side-len))
          b (range max-side-len 0 -1)
          :let [c (- perimeter a b)]
          :when (and (< a b c)
                     (= (+ (expt a 2) (expt b 2)) (expt c 2)))]

      (str "Perimeter: " perimeter
           " | a: " a ", b: " b ", c: " c
           " | Product: " (* a b c))
      ))))

(->> (solution 1000)
     (println "Solution 009:")
     (time))
