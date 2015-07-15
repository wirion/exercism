(ns meetup
  (:require [clj-time.core :as t]
            [clj-time.predicates :as pr]))

(def ^:private day-name-to-number
  {:monday 1
   :tuesday 2
   :wednesday 3
   :thursday 4
   :friday 5
   :saturday 6
   :sunday 7})

(defn- nth-week-monthday [month year monthweek weekday]
  (let [first-monthday-weekday (t/day-of-week (t/date-time year month 1))
        offset (- weekday first-monthday-weekday)
        monthday (+ 1
                    (* (- monthweek 1) 7)
                    (mod offset 7))]
    monthday))

(defn- last-week-monthday [month year nth-weekday]
  (let [joda-last-monthday (t/minus
                            (t/plus (t/date-time year month) (t/months 1))
                            (t/days 1))
        last-monthday-weekday (t/day-of-week joda-last-monthday)
        last-monthday (t/day joda-last-monthday)]
    (- last-monthday (mod (- last-monthday-weekday nth-weekday) 7))))

;; teenth days are from 13th to 19th of each month
(defn- teenth-week-monthday [month year day-of-week]
  (let [thirteenth-day-of-week (t/day-of-week (t/date-time year month 13))]
    (+ 13
       (mod
        (- day-of-week thirteenth-day-of-week)
        7))))

(defn meetup [month year day-name nth-mode]
  (let [weekday (day-name-to-number day-name)
        monthday
        (case nth-mode
          :first (nth-week-monthday month year 1 weekday)
          :second (nth-week-monthday month year 2 weekday)
          :third (nth-week-monthday month year 3 weekday)
          :fourth (nth-week-monthday month year 4 weekday)
          :last (last-week-monthday month year weekday)
          :teenth (teenth-week-monthday month year weekday))]
    [year month monthday]))
