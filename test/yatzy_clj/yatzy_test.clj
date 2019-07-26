(ns yatzy-clj.yatzy-test
  (:require [clojure.test :refer :all]
            [yatzy-clj.yatzy :refer :all]))

(deftest chance_scores_sum_of_all_dice
  (is (= 15 (chance [2 3 4 5 1])))
  (is (= 16 (chance [3 3 4 5 1]))))

(deftest yatzy_scores_50
  (is (= 50 (yatzy [4 4 4 4 4])))
  (is (= 50 (yatzy [6 6 6 6 6])))
  (is (= 0 (yatzy [6 6 6 6 3]))))


(deftest test_1s
  (is (= 1 (ones [1 2 3 4 5])))
  (is (= 2 (ones [1 2 1 4 5])))
  (is (= 0 (ones [6 2 2 4 5])))
  (is (= 4 (ones [1 2 1 1 1]))))


(deftest test_2s
  (is (= 4 (twos [1 2 3 2 6])))
  (is (= 10 (twos [2 2 2 2 2]))))

(deftest test_3s
  (is (= 6 (threes [1 2 3 2 3])))
  (is (= 12 (threes [2 3 3 3 3]))))

(deftest test_4s
  (is (= 12 (fours [4 4 4 5 5 ])))
  (is (= 8 (fours [4 4 5 5 5])))
  (is (= 4 (fours [4 5 5 5 5]))))

(deftest test_5s
  (is (= 10 (fives [4 4 4 5 5 ])))
  (is (= 15 (fives [4 4 5 5 5])))
  (is (= 20 (fives [4 5 5 5 5]))))

(deftest test_6s
  (is (= 0 (sixes [4 4 4 5 5 ])))
  (is (= 6 (sixes [4 4 6 5 5])))
  (is (= 18 (sixes [6 5 6 6 5]))))


(deftest get_count_of_die
  (is (= [0 0 0 2 2 1] (tally-die [4 4 6 5 5]))))


;(deftest one_pair
;  (is (= 6 (score_pair [3 4 3 5 6 ])))
;  (is (= 10 (score_pair [5 3 3 3 5])))
;  (is (= 12 (score_pair [5 3 6 6 5]))))




;@Test
;public void one_pair() {
;                        assertEquals(6, Yatzy.score_pair(3,4,3,5,6));
;                        assertEquals(10, Yatzy.score_pair(5,3,3,3,5));
;                        assertEquals(12, Yatzy.score_pair(5,3,6,6,5));
;                        }
;
;@Test
;public void two_Pair() {
;                        assertEquals(16, Yatzy.two_pair(3,3,5,4,5));
;                        assertEquals(16, Yatzy.two_pair(3,3,5,5,5));
;                        }
;
;@Test
;public void three_of_a_kind()
;{
; assertEquals(9, Yatzy.three_of_a_kind(3,3,3,4,5));
; assertEquals(15, Yatzy.three_of_a_kind(5,3,5,4,5));
; assertEquals(9, Yatzy.three_of_a_kind(3,3,3,3,5));
; }
;
;@Test
;public void four_of_a_knd() {
;                             assertEquals(12, Yatzy.four_of_a_kind(3,3,3,3,5));
;                             assertEquals(20, Yatzy.four_of_a_kind(5,5,5,4,5));
;                             assertEquals(9, Yatzy.three_of_a_kind(3,3,3,3,3));
;                             }
;
;@Test
;public void smallStraight() {
;                             assertEquals(15, Yatzy.smallStraight(1,2,3,4,5));
;                             assertEquals(15, Yatzy.smallStraight(2,3,4,5,1));
;                             assertEquals(0, Yatzy.smallStraight(1,2,2,4,5));
;                             }
;
;@Test
;public void largeStraight() {
;                             assertEquals(20, Yatzy.largeStraight(6,2,3,4,5));
;                             assertEquals(20, Yatzy.largeStraight(2,3,4,5,6));
;                             assertEquals(0, Yatzy.largeStraight(1,2,2,4,5));
;                             }
;
;@Test
;public void fullHouse() {
;                         assertEquals(18, Yatzy.fullHouse(6,2,2,2,6));
;                         assertEquals(0, Yatzy.fullHouse(2,3,4,5,6));
;                         }