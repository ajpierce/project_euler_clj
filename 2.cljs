#!/usr/bin/env planck

(defn fib-seq [limit]
  (loop [prev 1 sum 1 nums (list)]
    (if (< sum limit)
      (recur sum (+ sum prev) (conj nums sum))
      nums )))

(defn fib-evens-sum [limit]
  (->> (fib-seq limit)
       (filter even?)
       (reduce +)))

; (println (fib-evens-sum 100))
(println (fib-evens-sum 4000000))
