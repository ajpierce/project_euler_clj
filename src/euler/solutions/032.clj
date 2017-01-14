(ns euler.solutions.032
  "We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once.
  Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital."
  (:require [clojure.math.combinatorics :as combo])
  (:require [euler.common :refer [coll-to-int]]) )

(def digits (sorted-set 1 2 3 4 5 6 7 8 9 ))

(defn split [coll n1 n2]
  [(subvec coll 0 n1) (subvec coll n1 n2) (subvec coll n2)])

(defn possible-splits [coll]
  (let [max-split-index (-> (count coll) (quot 2) inc)]
    (for [n1 (range 1 max-split-index)
          n2 (range 2 (inc max-split-index))
          :when (> n2 n1)]
      (split coll n1 n2)) ))

(defn valid-product? [splits]
  (let [x (coll-to-int (first splits))
        y (coll-to-int (second splits))
        product (coll-to-int (last splits))]
    (= product (* x y)) ))

(->> (combo/permutations digits)
     (map possible-splits)
     (map (fn [splits] (->> splits
                            (filter valid-product?)
                            (map last)
                            (map coll-to-int) )))
     (flatten)
     (into #{})
     (reduce +)
     (println "Solution 032:")
     (time))
