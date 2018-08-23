(ns fourclojure.prob58)

; Write a function which allows you to create function compositions.
; The parameter list should take a variable number of functions,
; and create a function that applies them from right-to-left.

(apply reverse [[1 2 3]] )

(defn fcomp [& fs]
  (fn sub [& args]
    (first
      (reduce
        #(vector (apply %2 %1))
        args
        (reverse fs)))))

; 4clojure test cases
((fcomp rest reverse) [1 2 3 4]) ; [3 2 1]
((fcomp (partial + 3) second) [1 2 3 4]) ; 5
((fcomp zero? #(mod % 8) +) 3 5 7 9) ; true
((fcomp #(.toUpperCase %) #(apply str %) take) 5 "hello world!") ; "HELLO"
