(ns euler.common "A collection of helper functions"
  (:require [euler.math.primes :refer [factors]]) )

(defn parse-int [s]
  (Integer/parseInt (re-find #"\A-?\d+" s)))

(defn proper-divisors [n]
  (disj (factors n) n) )
