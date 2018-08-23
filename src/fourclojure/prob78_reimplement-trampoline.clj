(ns fourclojure.prob78)

(defn trampoline2 [f & params]
  (loop [result (apply f params)]
    (if
      (fn? result)
      (recur (result))
      result)))

; Everything below should eval to true
(= (letfn [(triple [x] #(sub-two (* 3 x)))
          (sub-two [x] #(stop?(- x 2)))
          (stop? [x] (if (> x 50) x #(triple x)))]
    (trampoline2 triple 2))
  82)
(= (letfn [(my-even? [x] (if (zero? x) true #(my-odd? (dec x))))
          (my-odd? [x] (if (zero? x) false #(my-even? (dec x))))]
    (map (partial trampoline2 my-even?) (range 6)))
  [true false true false true false])
