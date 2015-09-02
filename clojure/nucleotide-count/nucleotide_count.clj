(ns nucleotide-count)

(defn nucleotide-counts [dna-strand]
  {:pre [(string? dna-strand)]}
  (let [counts {\A 0, \T 0, \C 0, \G 0}]
    (merge counts (frequencies dna-strand))))

(defn count [nucleotide dna-strand]
  (when-not (#{\G \C \T \A} nucleotide)
    (throw (Exception. "invalid nucleotide")))
  ((nucleotide-counts dna-strand) nucleotide))
