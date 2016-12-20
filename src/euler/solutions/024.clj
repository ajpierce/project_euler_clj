(ns euler.solutions.024
  "What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?"
  (:require [clojure.math.combinatorics :as combo]))

(->> [0 1 2 3 4 5 6 7 8 9]
     (#(combo/nth-permutation % 999999))
     (println "Solution 024:")
     (time))
