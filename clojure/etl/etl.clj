(ns etl
  (:require [clojure.string :refer [lower-case]]))

(ns etl)

(defn transform [old-score-map]
  (for [[k v] old-score-map]
    [v k]))
