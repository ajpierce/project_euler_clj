(ns euler.solutions.006
    "Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum."
   (:require [clojure.math.numeric-tower :refer [expt]]))

(defn solution [start end]
  (let [r (range start (inc end))
        sum-of-squares (apply + (map #(expt % 2) r))
        square-of-sum (expt (apply + r) 2)]
    (- square-of-sum sum-of-squares)))

(->> (solution 1 100)
     (println "Solution 006:")
     (time))
