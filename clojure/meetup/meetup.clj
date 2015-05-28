(ns meetup
  (:require [clj-time.core :as t]
            [clj-time.predicates :as pr]))

(def ^:private day-name-to-number-map
  {:monday 1
   :tuesday 2
   :wednesday 3
   :thursday 4
   :friday 5
   :saturday 6
   :sunday 7})

(defn- nth-weekday [month year ordinal day-of-week])

(defn- last-weekday [month year day-of-week])

(defn- teenth-weekday [month year day-of-week])

(defn meetup [month year day-name ordinal-name]
  (let [day-of-week (day-name-to-number-map day-name)
        day-of-month
        (case ordinal-name
          :first (nth-weekday month year 1 day-of-week)
          :second (nth-weekday month year 2 day-of-week)
          :third (nth-weekday month year 3 day-of-week)
          :fourth (nth-weekday month year 4 day-of-week)
          :last (last-weekday month year day-of-week)
          :teenth (teenth-weekday month year day-of-week))]
    [year month day-of-month]))
