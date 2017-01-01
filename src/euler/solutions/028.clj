(ns euler.solutions.028
  "Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:

  21 22 23 24 25
  20  7  8  9 10
  19  6  1  2 11
  18  5  4  3 12
  17 16 15 14 13

  It can be verified that the sum of the numbers on the diagonals is 101.

  What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?"
  (:require [clojure.math.numeric-tower :refer [expt sqrt]]) )

(defn four-corners
  "For a given (odd) number representing side length, returns a set of the values
  at the four corners.
  e.g., (four-corners 5) => #{25 21 17 13}
        (four-corners 1) => #{1}  ; Always in the middle"
  [n]
  (let [m (expt n 2)
        size (dec n)
        l (repeat 4 size)]
    (set (map-indexed (fn [i v] (- m (* i v)) ) l)) ))

(->> (range 1001 0 -2)
     (map four-corners)
     (apply clojure.set/union)
     (reduce +)
     (println "Solution 028:")
     (time))
