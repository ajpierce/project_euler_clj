(ns euler.math.general "General math-related helper functions")

(defn factorial [n]
  (reduce *' (range 1 (inc n))))
