(ns scrabble-score
  (:require [clojure.string :refer [split upper-case]]))

(def ^:private score-classes
  [["AEIOULNRST" 1]
   ["DG" 2]
   ["BCMP" 3]
   ["FHVWY" 4]
   ["K" 5]
   ["JX" 8]
   ["QZ" 10]])

(def ^:private letter->score
  (apply merge (map (fn [class]
                      (apply #(zipmap %1 (repeat %2)) class))
                    score-classes)))

(defn score-letter [letter]
  (letter->score (Character/toUpperCase (first letter))))

(defn score-word [word]
  (apply + (map score-letter (split word #""))))
