(ns word-count
  (:require [clojure.string :refer [split]]))

(defn- add-in [coll word]
  (assoc coll word (let [word-count (coll word)]
                     (if word-count
                       (inc word-count)
                       1))))

(defn word-count [sentence]
  (let [count-map {}
        tokens (split sentence #"\s")]
    (reduce add-in count-map tokens)))
