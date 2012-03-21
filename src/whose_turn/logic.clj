(ns whose-turn.logic)
	(defn whose-turn [history users]

		(defn num-for-user [user, history]
			(count (filter #(= % user) history)))

		(first (reduce (fn [acc value] (if (< (last acc)(last value)) acc value))
	  		(map #( list % (num-for-user % history) ) users ))))


