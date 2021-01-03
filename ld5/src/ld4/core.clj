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

;; cycles back and forth
; for example if strlen is 6 and key is 3 we want 0 6 12 6 0 ... and so on
; because were going back and forth of the first column of a 2d array, in this case 6x3 array

(defn cycle-back-forth [strlen key]
  (let [keyminus2 (- key 2)
        up (take key (range 0 (* strlen key) strlen))                     ;; => '(0 6 12) or if 10 5 gets sent in '(0 10 20 30 40)
        down (take keyminus2 (range (* strlen keyminus2) 0 (- strlen)))]  ;; => (6) or (30 20 10)
    (take (+ strlen 1) (flatten (cycle [up down])))                       ;; returns strlen + 1 amount of numbers, based on previous function cycle back and forth function attempt
    )
  )
;;; were making an array assembly style, where we place a 2d array flat
(defn find-index [strlen key]
  (map + (cycle-back-forth strlen key) (range strlen)))


(defn encrypt [str key]
  (if (validate str key)
    (let [upd-string (string-to-char (replace-space str))
          strlen (stringlen upd-string)]

      (clojure.string/join
        (for [[pos char]
          (sort-by first (zipmap (find-index strlen key) upd-string))
          ]
          char)
      )
      )
    (println "Wrong message or key"))
  )

;; sorts find-index first, to assign correct indexes to divided letters
;; afterwards sorts seq by looking at each index and by modulo, modulo gives correct position
(defn decrypt [str key]
  (if (validate str key)
    (let [upd-string (string-to-char (replace-space str))
          strlen (stringlen upd-string)]

    (clojure.string/join
      (for [[pos char]
            (sort-by (fn [[pos char]] (mod pos strlen))
                     (zipmap (sort (find-index strlen key) ) upd-string))]
        char
        )
      )
     )
    (println "Wrong message or key"))
  )