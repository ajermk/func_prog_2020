;; 1. Find the last element of a list.
(defn my-last [xs]
  (if (empty? (rest xs))
    (first xs)
    (my-last (rest xs))))

(assert (= :d
           (my-last '(:a :b :c :d))))
;; 2. Find the N-th element of a list.
(defn get-nth [xs n]
  (if (= n 0)
    (first xs)
    (get-nth (rest xs) (dec n))))

(assert (= :d
           (get-nth '(:a :b :c :d) 3)))

;; 3. Find the length of a list
(defn my-length [xs]
  (if (empty? xs)
    0
    (inc (my-length (rest xs)))))

(assert (= 4
           (my-length '(:a :b :c :d))))

;; 4. Reverse a list.
;; i dont know how to make this work without concat or conj. cons doesnt work
(defn my-reverse [xs]
  (if (empty? xs)
    xs
    (concat (my-reverse (rest xs)) (list (first xs)))))

(assert (= '(:d :c :b :a)
           (my-reverse '(:a :b :c :d))))

;; 5. Find out whether a list is a palindrome.
(defn is-palindrome? [xs]
  (= xs (my-reverse xs)))

(assert (= true
           (is-palindrome? '(:a :b :c :b :a))))

;; 6. Duplicate the elements of a list.
(defn duplicate [xs]
  (reduce
    (fn [a b]
      (conj (conj a b) b))
    [] xs))                 ;; a or [] is empty at start, as function continues it saves result in []

(assert (= '(:a :a :b :b :c :c)
           (duplicate '(:a :b :c))))

;; 7. Eliminate consecutive duplicates of a list.
(defn compress [xs]
  (if (empty? xs)
    '()
    (if (some (partial = (first xs)) (rest xs))
      (compress (rest xs))
      (cons (first xs) (compress (rest xs)) ))))

(assert (= '(:a :b :c)
           (compress '(:a :a :b :b :c :c))))

;; 8. Remove the N-th element of a list
(defn remove-at [xs n]
  (when (seq xs)
    (if (= n 0)
      (remove-at (rest xs) (dec n))
      (cons (first xs) (remove-at (rest xs) (dec n))))))


(assert (= '(:a :b :d :e)
           (remove-at '(:a :b :c :d :e) 2)))

;; 9. Insert a new element at the N-th position of a list.
(defn insert-at [x xs n]
  (when (seq xs)
    (if (= n 0)
      (cons x (insert-at x xs (dec n)))
      (cons (first xs) (insert-at x (rest xs) (dec n))))))

(assert (= '(:a :b :x :c :d)
           (insert-at :x '(:a :b :c :d) 2)))

;; 10. Create a list containing all integers within a given range.
(defn my-range [a b]
  (when (<= a b)
    (cons a (my-range (inc a) b))))

(assert (= '(3 4 5 6 7)
           (my-range 3 7)))

;; 11. Concatenate two lists
(defn my-concat [xs ys]
  (if (empty? xs)
    ys
    (cons (first xs) (my-concat (rest xs) ys))))

(assert (= '(:a :b :c :d :e :f)
           (my-concat '(:a :b :c) '(:d :e :f))))

;; 12. Split a list into two parts; the length of the first part is given.
(defn my-drop [xs n]
  (when (seq xs)
    (if (> n 0)
      (my-drop (rest xs) (dec n))
      (cons (first xs) (my-drop (rest xs) (dec n))))))

(assert (= '(:d :e)
           (my-drop '(:a :b :c :d :e) 3)))

;; 13. Split a list into two parts; the length of the first part is given.
(defn my-take [xs n]
  (when (seq xs)
    (if (> n 0)
      (cons (first xs) (my-take (rest xs) (dec n)))
      )))

(assert (= '(:a :b :c)
           (my-take '(:a :b :c :d :e) 3)))

;; 14. Implement the filtering function
;; well
(defn my-filter [p xs]
  (if (seq xs)
    (if (p (first xs))
      (cons (first xs) (my-filter p (rest xs)))
      (my-filter p (rest xs)))))

(assert (= '(1 3 5)
           (my-filter odd? '(1 2 3 4 5))))

;; 15. Implement the mapping function
(defn my-map [f xs]
  (if (seq xs)
    (cons (f (first xs)) (my-map f (rest xs)))))

(assert (= '(2 3 4 5 6)
           (my-map inc '(1 2 3 4 5))))

;; 16. Implement the reducing function
(defn my-reduce [f acc xs]
  (if (seq xs)
    (f (first xs) (my-reduce f acc (rest xs)))
    0))

(assert (= 15
           (my-reduce + 0 '(1 2 3 4 5))))

;; 17. Implement the flattening function
;; im not smart enough for this and clojure doesnt have atoms like common lisp does
;; oh well
(defn my-flatten [xs]
  nil)

(assert (= '(:a :b :c :d :e)
           (my-flatten '(:a (:b (:c :d) :e)))))
