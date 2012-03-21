(ns whose-turn.web
  (:use compojure.core)
  (:require [compojure.route :as route]
            [compojure.handler :as handler]))

(defroutes main-routes
  (GET "/hello" [] "<h1>Hello World</h1>")
  (route/resources "/")
  (route/not-found "<h1>Page not found</h1>"))

(def app
  (handler/site main-routes))