(ns euler.solutions.036
  "Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2."
  (:require [euler.common :refer [palindrome?]]) )

(->> (range 1 1000000)
     (filter (fn [n] (and (palindrome? n)
                          (palindrome? (Integer/toString n 2)) )))
     (reduce +)
     (println "Solution 036:")
     (time))
