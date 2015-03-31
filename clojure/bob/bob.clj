(ns bob
  (:require [clojure.string :refer [blank? upper-case]]))

;; (defn response-for [addressed-sentence]
;;   "Whatever.")

(defn yelling? [addressed-sentence]
  (and (re-find #"[A-Z]" addressed-sentence)
       (= (upper-case addressed-sentence) addressed-sentence)))

(defn question? [addressed-sentence]
  (= \? (last addressed-sentence)))

(defn response-for [addressed-sentence]
  (cond
    (yelling? addressed-sentence) "Whoa, chill out!"
    (question? addressed-sentence) "Sure."
    (blank? addressed-sentence) "Fine. Be that way!"
    :else "Whatever."))
