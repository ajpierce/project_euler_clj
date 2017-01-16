(ns euler.solutions.034
  "145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
  Find the sum of all numbers which are equal to the sum of the factorial of their digits."
  (:require [euler.common :refer [split-int]])
  (:require [euler.math.general :refer [factorial]]) )

(def fac-vals
  (into (vector) (map factorial [0 1 2 3 4 5 6 7 8 9])))

(def max-val
  (let [nine-fac (get fac-vals 9)
        num-digits (count (split-int nine-fac))]
    (* num-digits nine-fac) ))

(defn curious-number? [n]
  (let [digits (split-int n)
        fac-digits (map #(get fac-vals %) digits)
        sum (reduce + fac-digits)]
    (= sum n)))


(->> (range 10 (inc max-val))
     (filter curious-number?)
     (reduce +)
     (println "Solution 034:")
     (time))
