(ns etl
  (:require [clojure.string :refer [lower-case]]))

(defn transform [old-score-map]
  (into {}
        (apply concat
               (for [[score words] old-score-map]
                 (for [word words]
                   [(lower-case word) score])))))
