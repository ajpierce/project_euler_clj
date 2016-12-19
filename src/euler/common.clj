(ns euler.common "A collection of helper functions")

(defn parse-int [s]
  (Integer/parseInt (re-find #"\A-?\d+" s)))
