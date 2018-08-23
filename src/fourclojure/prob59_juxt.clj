(ns fourcloure.prob59)

(defn juxt2 [& fns]
  (fn juxt2_inner [& args]
    (map
      #(apply (first %) (first (rest %)))
      (map vector fns (repeat args)))))

; Everything below should eval to true
(= [21 6 1] ((juxt2 + max min) 2 3 5 1 6 4))
(= ["HELLO" 5] ((juxt2 #(.toUpperCase %) count) "hello"))
(= [2 6 4] ((juxt2 :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10}))
