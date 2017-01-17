(ns euler.solutions.035
  "The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
  How many circular primes are there below one million?"
  (:require [euler.common :refer [coll-to-int split-int]])
  (:require [euler.math.primes :refer [primes]]) )

(def max-prime 1000000)
(def prime-nums (into #{} (primes max-prime)))
(defn prime? [n] (contains? prime-nums n))
(defn all-prime? [coll] (every? prime? coll))

(defn rotations [n]
  (let [coll (split-int n)
        num-digits (count coll)
        num-necessary (dec (* 2 num-digits))
        rot-coll (->> coll cycle (take num-necessary) (into (vector)))]
    (->> (range num-digits)
         (map (fn [i] (subvec rot-coll i (+ i num-digits))))
         (map coll-to-int) )))

(->> prime-nums
     (map rotations)
     (filter all-prime?)
     (flatten)
     (into #{})
     (count)
     (println "Solution 035:")
     (time))
