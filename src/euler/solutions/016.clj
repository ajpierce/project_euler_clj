(ns euler.solutions.016
  "2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
  What is the sum of the digits of the number 2^1000?"
  (:require [euler.common :refer [parse-int]])
  (:require [clojure.string :refer [join]])
  (:require [clojure.math.numeric-tower :refer [expt]]))

(->> (expt 2 1000)
     (str)
     (seq)
     (map str)
     (map parse-int)
     (reduce +)
     (println "Solution 016:")
     (time))
