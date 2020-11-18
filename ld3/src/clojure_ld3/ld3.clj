;; All of the Clojure collections are immutable and persistent.
;; All the collections support count for getting the size of the collection, conj for 'adding' to the collection, and seq to get a sequence that can walk the entire collection, though their specific behavior is slightly different for different types of collections.
;; list: Lists can be constructed with either a function or a quoted form. If you will be processing it sequentially use a list.
;; vector: If you will be chopping it into even sized chunks (like while sorting) use a vector. If you need to count the length use a vector. If you will be typing these by hand use a vector (to save a little quoting)
;; set: Sets are collections of unique values. If you will be searching for items, use a set.
;; maps: Maps store key-value pairs. Both maps and keywords can be used as lookup functions. Commas can be used to make maps more readable, but they are not required.
;; The map function takes two arguments: a function (f) and a sequence (s). Map returns a new sequence consisting of the result of applying f to each item of s. Do not confuse the map function with the map data structure.

;; 1. Find the last element of a list.
(defn my-last [xs]
  (first (reverse xs)))

(assert (= :d
           (my-last '(:a :b :c :d)))) ;; We need ' to prevent the list from being evaluated. ' will prevent a form from being evaluated. We are doing this here because we want to treat symbols as data in order to pass them to function.

;; 2. Find the N-th element of a list.
(defn get-nth [xs n]
  (nth xs n))

(assert (= :d
           (get-nth '(:a :b :c :d) 3)))

;; 3. Find the length of a list
(defn my-length [xs]
  (count xs))

(assert (= 4
           (my-length '(:a :b :c :d))))

;; 4. Reverse a list.
(defn my-reverse [xs]
  (reverse xs))

(assert (= '(:d :c :b :a)
           (my-reverse '(:a :b :c :d))))

;; 5. Find out whether a list is a palindrome.
(defn is-palindrome? [xs]
  (= xs (reverse xs)))

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
  (distinct xs))

(assert (= '(:a :b :c)
           (compress '(:a :a :b :b :c :c))))

;; 8. Remove the N-th element of a list
(defn remove-at [xs n]
  (keep-indexed #(if (not= %1 n) %2) xs))


(assert (= '(:a :b :d :e)
           (remove-at '(:a :b :c :d :e) 2)))

;; 9. Insert a new element at the N-th position of a list.
(defn insert-at [x xs n]
  (flatten (conj (drop n xs) x (take n xs))))

(assert (= '(:a :b :x :c :d)
           (insert-at :x '(:a :b :c :d) 2)))

;; 10. Create a list containing all integers within a given range.
(defn my-range [a b]
  (range a (+ b 1)))

(assert (= '(3 4 5 6 7)
           (my-range 3 7)))

;; 11. Concatenate two lists
(defn my-concat [xs ys]
  (concat xs ys))

(assert (= '(:a :b :c :d :e :f)
           (my-concat '(:a :b :c) '(:d :e :f))))

;; 12. Split a list into two parts; the length of the first part is given.
(defn my-drop [xs n]
  (drop n xs))

(assert (= '(:d :e)
           (my-drop '(:a :b :c :d :e) 3)))

;; 13. Split a list into two parts; the length of the first part is given.
(defn my-take [xs n]
  (take n xs))

(assert (= '(:a :b :c)
           (my-take '(:a :b :c :d :e) 3)))

;; 14. Implement the filtering function
(defn my-filter [p xs]
  (filter p xs))

(assert (= '(1 3 5)
           (my-filter odd? '(1 2 3 4 5))))

;; 15. Implement the mapping function
(defn my-map [f xs]
  (map f xs))

(assert (= '(2 3 4 5 6)
           (my-map inc '(1 2 3 4 5))))

;; 16. Implement the reducing function
(defn my-reduce [f acc xs]
  (reduce f acc xs))

(assert (= 15
           (my-reduce + 0 '(1 2 3 4 5))))

;; 17. Implement the flattening function
(defn my-flatten [xs]
  (flatten xs))

(assert (= '(:a :b :c :d :e)
           (my-flatten '(:a (:b (:c :d) :e)))))