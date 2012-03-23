(ns whose-turn.web
  (:use compojure.core)
  (:use somnium.congomongo)
  (:use somnium.congomongo.coerce)
  (:use [clojure.data.json :only [json-str read-json]])
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [whose-turn.logic :as logic]
            [whose-turn.dbaccess :as db]
            ))

  ;yeahaa! 
  (extend-protocol ConvertibleFromMongo
      org.bson.types.ObjectId
      (mongo->clojure [^org.bson.types.ObjectId d keywordize] (str d)))

(defn json-response [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/json"}
   :body (json-str data)})

(def conn
      (make-connection "whose-turn"
                 :host "127.0.0.1"
                 :port 27017))
  (set-connection! conn)

(defn whoseturn []
  (let [users (map #(:name %) (db/all-users))
        history (map #(:name %) (db/all-history))]
    (logic/whose-turn history users)))


(defroutes main-routes
  (GET "/" [] (ring.util.response/redirect "/index.html"))
  (GET "/users" [] (json-response {:users (db/all-users)}))
  (POST "/user/add/:name" [name] (json-response (db/add-user name)))
  (POST "/user/taketurn/:name" [name] (json-response (db/take-turn name)))
  (GET "/history" [] (json-response {:history (db/all-history) }))
  (GET "/whoseturn" [] (json-response {:name (whoseturn)}))


  (route/resources "/")
  (route/not-found "<h1>Page not found</h1>"))

(def app
  (handler/site main-routes))