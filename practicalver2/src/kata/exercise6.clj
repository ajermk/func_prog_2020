(ns kata.exercise6
  (:use [clojure.test]
        [kata.data]))

(testing "Numbers Seq"

  ; Create a seq only with multiples of 3, starting from 0, size of 10, by using for example (range ...)
  (let [numbers-list (take 10  (iterate #(+ % 3) 0))]

    (is (= numbers-list
           [0, 3, 6, 9, 12, 15, 18, 21, 24, 27]))))
