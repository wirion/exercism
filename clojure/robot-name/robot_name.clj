(ns robot-name)

;; maybe use a random stream implementation?
(defn- random-letter []
  (char (+ 65 (rand-int 26))))

(defn- make-name []
  (str (random-letter)
       (random-letter)
       (format "%03d" (rand-int 1000))))

;; manufacture robot
(defn robot []
  (atom {:name (make-name)}))

(defn robot-name [robot] (:name @robot))

(defn reset-name [robot]
  (swap! robot assoc :name (make-name)))
