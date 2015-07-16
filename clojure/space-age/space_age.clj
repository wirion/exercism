(ns space-age)

(def ^:private earth-orbital-period 31557600)

(def ^:private orbital-periods
  {:mercury (* 0.2408467 earth-orbital-period)
   :venus (* 0.61519726 earth-orbital-period)
   :mars (* 1.8808158 earth-orbital-period)
   :earth (* 1 earth-orbital-period)
   :jupiter (* 11.862615 earth-orbital-period)
   :saturn (* 29.447498 earth-orbital-period)
   :uranus (* 84.016846 earth-orbital-period)
   :neptune (* 164.79132 earth-orbital-period)})

(defn- compute-age [planet, seconds]
  (double
   (/
    seconds
    (planet orbital-periods))))

(defn on-mercury [seconds]
  (compute-age :mercury seconds))
(defn on-venus [seconds]
  (compute-age :venus seconds))
(defn on-earth [seconds]
  (compute-age :earth seconds))
(defn on-mars [seconds]
  (compute-age :mars seconds))
(defn on-jupiter [seconds]
  (compute-age :jupiter seconds))
(defn on-saturn [seconds]
  (compute-age :saturn seconds))
(defn on-uranus [seconds]
  (compute-age :uranus seconds))
(defn on-neptune [seconds]
  (compute-age :neptune seconds))
