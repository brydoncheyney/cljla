(ns cljla.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [cljla.view :as view]
            [cljla.middleware :refer :all]))

(defroutes app-routes
           (GET "/" [] "je$us loves amerika")
           (GET "/bootstrap" []
                (view/page {:title    "je$us loves amerika"
                            :header   "header"
                            :articles [{:title "a" :content "aaaaa"}
                                       {:title "b" :content "bbbbb"}
                                       {:title "c" :content "ccccc"}]}))
           (route/not-found "Not Found"))

(def app
  (-> app-routes
      (wrap-defaults site-defaults)
      (wrap-logging)))
