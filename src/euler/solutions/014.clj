(ns euler.solutions.014
  "The following iterative sequence is defined for the set of positive integers:

  n → n/2 (n is even)
  n → 3n + 1 (n is odd)

  Using the rule above and starting with 13, we generate the following sequence:

  13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
  It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

  Which starting number, under one million, produces the longest chain?")

(defn collatz [n]
  (loop [n n nums []]
    (cond (= 1 n) (conj nums n)
          (even? n) (recur (/ n 2) (conj nums n))
          (odd? n) (recur (inc (* n 3)) (conj nums n))
          true nums   ; Some kind of error, like n = 0 or something
          )))

(->> (range 99999 1000001)
     (map collatz)
     (map #(hash-map :i (first %) :len (count %)))
     (apply max-key :len)
     (println "Solution 014:")
     (time))
