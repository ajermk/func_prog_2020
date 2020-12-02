(ns kata.exercise9
  (:use [clojure.test]
        [kata.data]))

(testing "Razor-sharp Focus"

  ; Implement a custom function joining a seq of customer names into csv,
  ;;  by combining (reduce ...) (partial ...) and (join ...)
  (let [joiner (fn [xs] "")
        csv (joiner (:customers mall))]

    (is (= csv "Joe,Steven,Patrick,Diana,Chris,Kathy,Alice,Andrew,Martin,Amy"))))

(testing "I want you now"

  ; Implement a function which creates a map with keys as item name and
  ;;  values as set of customers who are wanting to buy that item.
  (let [audience-analyzer (fn [market] {})
        target-audience (audience-analyzer mall)]

    (is (= (target-audience "plane") #{"Chris"}))
    (is (= (target-audience "onion") #{"Patrick", "Amy"}))
    (is (= (target-audience "ice cream") #{"Patrick", "Steven"}))
    (is (= (target-audience "earphone") #{"Steven"}))
    (is (= (target-audience "plate") #{"Joe", "Martin"}))
    (is (= (target-audience "fork") #{"Joe", "Martin"}))
    (is (= (target-audience "cable") #{"Diana", "Steven"}))
    (is (= (target-audience "desk") #{"Alice"}))))

(testing "bitList2BitString"

  ; Create a function building a string of "n'th bit is ON" from an encoded specification.
  ;;  See tests for examples
  (let [bitSpec1 "3"
        bitSpec2 "1,3,5"
        bitSpec3 "1-3"
        bitSpec4 "7,1-3,5"
        bitSpec "22-24,9,42-44,11,4,46,14-17,5,2,38-40,33,50,48"
        bit-decoder (fn [spec] "implement me")]

    (is (= (bit-decoder bitSpec1) "001"))
    (is (= (bit-decoder bitSpec2) "10101"))
    (is (= (bit-decoder bitSpec3) "111"))
    (is (= (bit-decoder bitSpec4) "1110101"))
    (is (= (bit-decoder bitSpec)  "01011000101001111000011100000000100001110111010101"))))