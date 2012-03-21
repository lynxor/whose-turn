(ns whose-turn.test.logic
  (:use [whose-turn.logic])
  (:use [clojure.test]))

	(def users #{:pietie :jannie :sannie})
	(def strusers #{"pietie" "jannie" "sannie"})


(deftest rightresult
  (is (= :jannie (whose-turn [ :pietie :pietie :jannie :sannie] users)))
  (is (= "jannie" (whose-turn [ "pietie" "sannie"] strusers)))
  (is (= :sannie (whose-turn [ :pietie :pietie :jannie :jannie :sannie] users)))
  (is (= :pietie (whose-turn [ :pietie :pietie :jannie :jannie :jannie :sannie :sannie :sannie] users)))
  (is (= :sannie (whose-turn [ :pietie :jannie :sannie :pietie :jannie] users)))
  (is (= :jannie (whose-turn [ :pietie :jannie :sannie :pietie :sannie] users)))
  (is (= :jannie (whose-turn [ :pietie :jannie :sannie :pietie :jannie :sannie :pietie] users))))
