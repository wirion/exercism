(ns bob
  (:require [clojure.string :refer [blank? upper-case]]))

;; (defn response-for [message]
;;   "Whatever.")

(defn yelling? [message]
  (and (re-find #"[a-zA-Z]" message)
       (= (upper-case message) message)))

(defn question? [message]
  (= \? (last message)))

(defn response-for [message]
  (cond
    (yelling? message) "Whoa, chill out!"
    (question? message) "Sure."
    (blank? message) "Fine. Be that way!"
    :else "Whatever."))
