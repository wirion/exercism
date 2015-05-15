(ns nucleotide-count)

(defn count [nucleotide dna-strand]
  {:pre [(char? nucleotide) (string? dna-strand)]}
  ((frequencies dna-strand) nucleotide))

(defn nucleotide-counts [dna-strand])
