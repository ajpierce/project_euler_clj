(ns euler.solutions.20 "Find the sum of the digits in the number 100!"
  (:require [clojure.string :refer [join]])
  (:require [clojure.math.numeric-tower :refer [expt]]))

(defn factorial [n]
  (apply *' (range 1 (inc n))))

(defn parse-int [s]
  (Integer/parseInt (re-find #"\A-?\d+" s)))

(->> (factorial 100)
     (str)
     (seq)
     (map str)
     (map parse-int)
     (reduce +)
     (println)
     (time))
