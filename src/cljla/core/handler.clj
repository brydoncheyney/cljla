(ns cljla.core.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [net.cgrand.enlive-html :as html]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(def bootstrap "public/templates/bootstrap.html")

(html/deftemplate index-page bootstrap
                  [title]
                  [:title] (html/content title))

(defn page
  [title]
  (apply str (index-page title)))

(defroutes app-routes
           (GET "/" [] "je$us loves amerika")
           (GET "/bootstrap" [] (page "je$us loves amerika"))
           (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
