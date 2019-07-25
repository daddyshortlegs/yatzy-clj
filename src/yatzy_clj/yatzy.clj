(ns yatzy-clj.yatzy
  (:gen-class))

(defn chance [dice]
  (reduce + dice)
  )

(defn ones [dice]
  (reduce + (filter (fn [die] (= 1 die)) dice)))


;public static int ones(int d1, int d2, int d3, int d4, int d5) {
;  int sum = 0;
;  if (d1 == 1) sum++;
;  if (d2 == 1) sum++;
;  if (d3 == 1) sum++;
;  if (d4 == 1) sum++;
;  if (d5 == 1)
;  sum++;
;
;  return sum;
;  }

;public static int yatzy(int... dice)
;{
; int[] counts = new int[6];
;    for (int die : dice)
;    counts[die-1]++;
; for (int i = 0; i != 6; i++)
;          if (counts[i] == 5)
;          return 50;
;          return 0;
; }
