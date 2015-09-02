(ns nucleotide-count)

(defn nucleotide-counts [dna-strand]
  {:pre [(string? dna-strand)]}
  (let [counts {\A 0, \T 0, \C 0, \G 0}]
    (merge counts (frequencies dna-strand))))

(defn count [nucleotide dna-strand]
  (or ((nucleotide-counts dna-strand) nucleotide)
      (throw (Exception. "invalid nucleotide"))))
