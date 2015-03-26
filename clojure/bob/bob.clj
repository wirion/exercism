(ns bob
  (:require [clojure.string :refer [trim upper-case]]))

;; (defn response-for [addressed-sentence]
;;   "Whatever.")

(defn yelling? [addressed-sentence]
  (= (upper-case addressed-sentence) addressed-sentence))
;; (nil? (re-find #"[a-z]" addressed-sentence)

(defn question? [addressed-sentence]
  (= \? (last addressed-sentence)))

(defn not-saying-anything? [addressed-sentence]
  (= "" (trim addressed-sentence)))

(defn response-for [addressed-sentence]
  (cond
    (yelling? addressed-sentence) "Whoa, chill out!"
    (question? addressed-sentence) "Sure."
    (not-saying-anything? addressed-sentence) "Fine. Be that way!"
    :else "Whatever."))
