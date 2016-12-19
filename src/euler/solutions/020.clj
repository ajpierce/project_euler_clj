(ns euler.solutions.020 "Find the sum of the digits in the number 100!"
  (:require [euler.common :refer [parse-int]])
  (:require [clojure.string :refer [join]])
  (:require [clojure.math.numeric-tower :refer [expt]]))

(defn factorial [n]
  (apply *' (range 1 (inc n))))

(->> (factorial 100)
     (str)
     (seq)
     (map str)
     (map parse-int)
     (reduce +)
     (println "Solution 020:")
     (time))
