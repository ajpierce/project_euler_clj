(ns euler.solutions.001
  "If we list all the natural numbers below 10 that are multiples of 3 or 5, we
  get 3, 5, 6 and 9. The sum of these multiples is 23.

  Find the sum of all the multiples of 3 or 5 below 1000.")

(defn mod3or5? [number]
  (or
    (= 0 (mod number 3))
    (= 0 (mod number 5))))

(defn solution [limit]
  ( ->> (range limit)
        (filter mod3or5?)
        (reduce +)))

(->> (solution 1000)
     (println "Solution 001:")
     (time))
