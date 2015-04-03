(ns bob
  (:require [clojure.string :refer [blank? upper-case]]))

(defn- contains-some-letter? [message]
  (re-find #"\p{L}" message))

(defn- all-letters-are-uppercase? [message]
  (= (upper-case message) message))

(defn- yelling? [message]
  (and (contains-some-letter? message)
       (all-letters-are-uppercase? message)))

(defn- question? [message]
  (= \? (last message)))

(defn response-for [message]
  (condp #(%1 %2) message
    yelling? "Whoa, chill out!"
    question? "Sure."
    blank? "Fine. Be that way!"
    "Whatever."))
