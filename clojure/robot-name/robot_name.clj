(ns robot-name)

(defn- random-initials []
  (str (char (+ 65 (rand-int 25))) (char (+ 65 (rand-int 25)))))

(defn robot []
  (str (random-initials) (format "%03d" (rand-int 1000))))

(defn robot-name [robot])
