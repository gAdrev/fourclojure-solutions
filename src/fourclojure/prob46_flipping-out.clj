(ns fourclojure.prob46)

; Write a higher-order function which flips the order of
; the arguments of an input function.
(defn flipped [f]
  (fn [& args]
    (let [revargs (reverse args)]
      (apply f revargs))))

; 4clojure test cases
((flipped nth) 2 [1 2 3 4 5]) ; 3
((flipped >) 7 8) ; true
((flipped quot) 2  8) ; 4
((flipped take) [1 2 3 4 5] 3) ; [1 2 3]
