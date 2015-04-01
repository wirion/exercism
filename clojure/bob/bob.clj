(ns bob
  (:require [clojure.string :refer [blank? upper-case]]))

(defn- contains-some-letter? [message]
  (re-find #"[a-zA-Z]" message))

(defn- all-letters-are-uppercase? [message]
  (= (upper-case message) message))

(defn- yelling? [message]
  (and (contains-some-letter? message)
       (all-letters-are-uppercase? message)))

(defn- question? [message]
  (= \? (last message)))

(defn response-for [message]
  (cond
    (yelling? message) "Whoa, chill out!"
    (question? message) "Sure."
    (blank? message) "Fine. Be that way!"
    :else "Whatever."))
