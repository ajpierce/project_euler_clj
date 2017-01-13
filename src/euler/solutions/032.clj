(ns euler.solutions.032
  "We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once.

  Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital."
  (:require [clojure.math.numeric-tower :refer [expt sqrt]])
  (:require [euler.common :refer [parse-int]]))

(def digits (sorted-set 1 2 3 4 5 6 7 8 9 ))

(defn pandigital? [nums]
  (let [nstr (if (coll? nums) (clojure.string/join "" nums) (str nums))
        nset (into (sorted-set) (map #(Character/digit % 10) (seq nstr)))]
    (= nset digits) ))

(->> (for [x (range 1 (sqrt 123456789))
           y (range 1 (sqrt 123456789))
           :let [product (* x y)]
           :when (pandigital? [x y product])]
       product)
     (into #{})
     (reduce +)
     (println "Solution 032:")
     (time))
