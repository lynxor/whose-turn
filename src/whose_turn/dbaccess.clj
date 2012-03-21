(ns whose-turn.dbaccess
	(:use somnium.congomongo))

	(import 'java.util.Date)

	(defn all-users []
		(fetch :users))

	(defn add-user [user]
		(insert! :users { :name user }))

	(defn add-users [users]
		(mass-insert! :users 
			(map (fn [user] { :name user }) users)))

	(defn all-history []
		(fetch :history))

	(defn take-turn [user]
		(insert! :history  {:name user :date (.getTime (Date.) )}))


