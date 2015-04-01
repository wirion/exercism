(ns word-count
  (:require [clojure.string :refer [split]]))

(defn- increase-count [count-map word]
  (assoc count-map word (let [word-count (count-map word)]
                     (if word-count
                       (inc word-count)
                       1))))

(defn word-count [sentence]
  (let [count-map {}
        tokens (split sentence #"\s")]
    (reduce increase-count count-map tokens)))
