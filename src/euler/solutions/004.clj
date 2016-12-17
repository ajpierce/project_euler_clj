(ns euler.solutions.004
  "A palindromic number reads the same both ways.
  The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

  Find the largest palindrome made from the product of two 3-digit numbers."
  (:require [clojure.string :refer [join]]) )

; Reverse either numbers or strings, but NOT sequences or iterables!
(defn reverse-alphanumeric [x] (join (reverse (str x))) )

(defn palindrome? [candidate]
  (= (str candidate) (reverse-alphanumeric candidate)))

(def three-digit-numbers (range 100 1000))

(def three-digit-multiples
  (set
    (for [x three-digit-numbers
          y three-digit-numbers]
      (* x y) )))

(->> three-digit-multiples
     (filter palindrome?)
     (apply max)
     (println "Solution 004:")
     (time))
