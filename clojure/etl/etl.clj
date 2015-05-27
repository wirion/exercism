(ns etl
  (:require [clojure.string :refer [lower-case]]))

(defn transform [old-score-map]
  (for [[k v] old-score-map]
    [v k]))
