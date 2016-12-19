(ns euler.solutions.019
  "How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?"
  (:require [clj-time.core :refer [date-time]])
  (:require [clj-time.predicates :refer [sunday?]]) )

(def dates (for [years (range 1901 2001)
                 months (range 1 13)]
             [years months]))

(->> dates
     (map #(date-time (first %) (last %) 1))
     (filter sunday?)
     (count)
     (println "Solution 019:")
     (time))
