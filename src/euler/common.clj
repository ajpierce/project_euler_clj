(ns euler.common "A collection of helper functions"
  (:require [clojure.string :refer [join]])
  (:require [euler.math.primes :refer [factors]]) )

(defn parse-int [s]
  (Integer/parseInt (re-find #"\A-?\d+" s)))

(defn coll-to-int "Converts a collection of numbers to an int. Cannot handle nested collections (because adding a flatten made it much slower)"
  [coll]
  (->> coll (join "") parse-int) )

(defn proper-divisors [n]
  (disj (factors n) n) )
