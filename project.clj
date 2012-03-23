(defproject whose-turn "1.0.0-SNAPSHOT"
	:description "Whose turn is it?"
	:dependencies [
		[org.clojure/clojure "1.3.0"] 
		[congomongo "0.1.8"]
		[compojure "1.0.1"]
		; [clj-json "0.3.2"]
	]
	:dev-dependencies [[lein-ring "0.5.4"]]
    :ring {:handler whose-turn.web/app})
