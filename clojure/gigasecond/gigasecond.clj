(ns gigasecond
  (:require [clj-time.core :as t]
            [clj-time.predicates :as pr]))

(def ^:private gigasecond 1000000000)

(defn from [year month day]
  (let [t-date (t/plus
                (t/date-time year month day)
                (t/seconds gigasecond))]
    ((juxt t/year t/month t/day) t-date)))
