(ns cljla.core.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [cljla.core.view :as view]
            [cljla.core.middleware :refer :all]))

(defroutes app-routes
           (GET "/" [] "je$us loves amerika")
           (GET "/bootstrap" [] (view/page "je$us loves amerika"))
           (route/not-found "Not Found"))

(def app
  (-> app-routes
      (wrap-defaults site-defaults)
      (wrap-logging)))
