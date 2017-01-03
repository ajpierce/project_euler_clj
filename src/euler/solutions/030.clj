(ns euler.solutions.030
  "Find the sum of all the numbers that can be written as the sum of fifth powers of their digits"
  (:require [clojure.math.numeric-tower :refer [expt ]])
  (:require [euler.common :refer [parse-int]]) )

(defn sum-of-fifth-power-digits? [n]
  (->> n
       str
       (#(clojure.string/split % #""))
       (map parse-int)
       (map #(expt % 5))
       (reduce +)
       (= n) ))

(->> (range 2 (inc (* 5 (expt 9 5))))
     (filter sum-of-fifth-power-digits?)
     (reduce +)
     (println "Solution 030:")
     (time))
