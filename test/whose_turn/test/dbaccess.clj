(ns whose-turn.test.dbaccess
  (:use [whose-turn.dbaccess])
  (:use [clojure.test])
  (:use somnium.congomongo))

	(def conn
			(make-connection "whose-turn-test"
	               :host "127.0.0.1"
	               :port 27017))
	(set-connection! conn)

	(drop-database! "whose-turn-test")

	(add-users '("pietie" "jannie" "sannie"))

	(take-turn "pietie")
	(take-turn "jannie")
	(take-turn "sannie")
	(take-turn "pietie")

	;just checking to see if setup correctly
	(print (map (fn [user] (:name user)) (all-users) ))

	(deftest usertest
		(is (= '("pietie" "jannie" "sannie") (map (fn [user] (:name user)) (all-users) ))))

	(deftest historytest
		(is (= '("pietie", "jannie", "sannie", "pietie") (map (fn [history] (:name history)) (all-history)))))
