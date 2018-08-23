(ns fourclojure.prob67)

(take-while even? [0 2 4 5 6])

(defn nprimes [n]
  (letfn [(next-prime
            [primes]
            (some
              (fn [candidate]
                (if
                  (every? (partial not= 0) (map #(mod candidate %) primes))
                  candidate
                  false))
              (iterate inc (inc (last primes)))))]
    (loop [primes [2]]
      (if
        (>= (count primes) n)
        primes
        (recur (conj primes (next-prime primes)))))))

(= (nprimes 2) [2 3])
(= (nprimes 5) [2 3 5 7 11])
(= (last (nprimes 100)) 541)
