(ns euler.solutions.017
  "If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

  If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?

  NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of 'and' when writing out numbers is in compliance with British usage."
  (:require [clojure.string :as string])
  (:require [clojure.pprint :refer [cl-format]]) )

(defn number-to-word
  "Takes an integer, converts it to a (UK) English representation of the integer, and then removes the spaces and hyphens"
  [n]
  (->> n
       (cl-format nil "~r")
       (#(string/replace % "hundred " "hundred and"))
       (#(string/replace % "-" ""))
       (#(string/replace % " " "")) ))

(->> (range 1 1001)
     (map number-to-word)
     (string/join)
     (count)
     (println "Solution 017:")
     (time))
