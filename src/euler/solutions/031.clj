(ns euler.solutions.031
  "In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:

  1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).

  How many different ways can £2 be made using any number of coins?")

; Disclaimer: I found the recursive algorithm here: https://andrew.neitsch.ca/publications/m496pres1.nb.pdf
; I will take credit for the tail-recursive implementation ;)

(def coins [1 2 5 10 20 50 100 200])

(defn coin-combos [amt]
  (loop [stack [[amt 1]] acc 0]
    (if (empty? stack)
      acc
      (let [item (first stack)
            [n k] item
            leftovers (rest stack)]

        (cond (or (> k (count coins))
                  (< n 0)) (recur leftovers acc)
              (= n 0) (recur leftovers (inc acc))
              :else (recur (conj leftovers
                                 [n, (inc k)]
                                 [(- n (get coins (dec k))) k])
                           acc)) ))))

(->> (coin-combos 200)
     (println "Solution 031:")
     (time))
