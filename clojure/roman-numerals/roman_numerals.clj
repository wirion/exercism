(ns roman-numerals
  (:refer-clojure :exclude [compare]))

(defn numerals
  "Convert Arabic numbers to Roman numbers"
  [roman-number]
  (reverse (seq roman-number)))

;; Hmm, how to parse this?
;; I'm thinking state machine, maybe stateful transducer.
;; We also need to establish an order: I < V < X < L < C < D < M
;; The letters following V, L, D are always smaller than themselves, and V, L, D may never appear next to themselves.
;; X, C, M can appear as singles, doubles or triples.
;; Treat arabic number as powers of ten from right to left (i.e. digit by digit)?
