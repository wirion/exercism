(ns meetup
  (:require [clj-time.core :as t]
            [clj-time.predicates :as pr]))

(def ^:private day-keyword-to-number-map
  {:monday 1
   :tuesday 2
   :wednesday 3
   :thursday 4
   :friday 5
   :saturday 6
   :sunday 7})

(defn- nth-weekday [month year which-week day-of-week]
  (let [first-day-of-month-day-of-week (t/day-of-week (t/date-time year month 1))
        offset (- day-of-week first-day-of-month-day-of-week)
        day-of-month (+ 1
                        (* (- which-week 1) 7)
                        (mod offset 7))]
    day-of-month))

(defn- last-weekday [month year day-of-week]
  (let [last-day-of-month-joda-format (t/minus
                                       (t/plus (t/date-time year month) (t/months 1))
                                       (t/days 1))
        last-day-of-month-day-of-week (t/day-of-week last-day-of-month-joda-format)
        last-day-of-month (t/day last-day-of-month-joda-format)]
    (- last-day-of-month (mod (- last-day-of-month-day-of-week day-of-week) 7))))

;; teenth days are from 13th to 19th of each month
(defn- teenth-weekday [month year day-of-week]
  (let [thirteenth-day-of-week (t/day-of-week (t/date-time year month 13))]
    (+ 13 (mod (- day-of-week thirteenth-day-of-week) 7))))

(defn meetup [month year day-keyword nth]
  (let [day-of-week (day-keyword-to-number-map day-keyword)
        day-of-month
        (case nth
          :first (nth-weekday month year 1 day-of-week)
          :second (nth-weekday month year 2 day-of-week)
          :third (nth-weekday month year 3 day-of-week)
          :fourth (nth-weekday month year 4 day-of-week)
          :last (last-weekday month year day-of-week)
          :teenth (teenth-weekday month year day-of-week))]
    [year month day-of-month]))
