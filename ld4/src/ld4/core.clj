(ns ld4.core)

;; using regex
(defn validate [str key]
  (if (and (re-matches #"^[a-zA-Z\s_]+$" str) (> key 1))
    true
    false)
  )
(defn replace-space [str]
  (clojure.string/replace str " " "_"))

(defn string-to-char [str]
  (vec str))

(defn stringlen [str]
  (count str))

;; because clojure has cycle func but not cycle back and forth so i had to make this non-functional mess
;; for example if strlen is 6 and key is 3 we want 0 6 12 6 0 ... and so on
;; because were going back and forth of the first column of a 2d array, in this case 6x3 array
;;;;
(defn cycle-back-forth [strlen key]
  ;; define "variables"
  (def going-down -1)                                       ;; -1 false 1 true bc bools didnt want to work
  (def row 0)
  (vec
    (loop [iter 0
           vect '(0)]
      (if (< iter strlen)
        ;; cycle up and down
        (do
          (if (or (= row 0) (= row (* strlen (- key 1))))
            (def going-down (* going-down -1))
            )
          (def row
            (if (= 1 going-down)
              (+ row strlen)
              (- row strlen)))
          ;; recursively loop
          (recur (inc iter) (cons row vect))
          )
        ;; return reverse due to cons/recursion when if is false during loop
        (reverse vect))
      )))

;; were making an array assembly style, where we place a 2d array flat
(defn find-index [strlen key]
  (map + (cycle-back-forth strlen key) (range strlen)))



(defn encrypt
  [str key]
  (if (validate str key)
    (do
      (def upd-string (string-to-char (replace-space str)))
  (def strlen (stringlen upd-string))

  (clojure.string/join
    (for [[pos char]
          (sort-by first (zipmap (find-index strlen key) upd-string))
          ] char)
    ))
    (println "Wrong message or key"))
  )

;; this doesnt work
(defn decrypt
  [str key]
  (def upd-string (string-to-char (replace-space str)))
  (def strlen (stringlen upd-string))

  (clojure.string/join
    (for [[pos char]
          (sort-by first
                   (zipmap (sort (find-index strlen key) ) upd-string)
                   )]
      char
      )
    )
  )


