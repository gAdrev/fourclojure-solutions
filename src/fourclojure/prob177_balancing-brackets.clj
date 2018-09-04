(ns prob177)

(comment
Balancing Brackets

Difficulty:	Medium Topics:	parsing


When parsing a snippet of code it's often a good idea to do a sanity check to
see if all the brackets match up. Write a function that takes in a string and
returns truthy if all square [ ] round ( ) and curly { } brackets are properly
paired and legally nested, or returns falsey otherwise.
)

(defn bb [s]
  (empty?
    (let [openers #{\{ \( \[}
          closers {\} \{, \) \(, \] \[}]
      (reduce
        (fn [acc v]
          (println "reducer acc: " acc ", v: " v)
          (cond
           (contains? openers v) (conj acc v)
           (contains? closers v) (if (= (peek acc) (get closers v))
                                   (pop acc)
                                   (conj acc \*))
           :else acc))
        []
        s))))

; everything below should eval to true
(bb "This string has no brackets.")
(bb "class Test {
      public static void main(String[] args) {
        System.out.println(\"Hello world.\");
      }
    }")
(not (bb "(start, end]"))
(not (bb "())"))
(not (bb "[ { ] } "))
(bb "([]([(()){()}(()(()))(([[]]({}()))())]((((()()))))))")
(not (bb "([]([(()){()}(()(()))(([[]]({}([)))())]((((()()))))))"))
(not (bb "["))

