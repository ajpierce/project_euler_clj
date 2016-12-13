(ns euler.solutions.15
  "Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
  How many such routes are there through a 20×20 grid?"
  (:require [clojure.math.combinatorics :as combo]))

(defn build-grid [x y]
  (flatten (list
             (take x (repeat :right))
             (take y (repeat :down)) )))

(defn solution [x y]
  (->> (build-grid x y)
       (combo/count-permutations) ))

(time (println (solution 20 20)))
