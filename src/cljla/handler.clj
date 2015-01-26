(ns cljla.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [cljla.view :as view]
            [cljla.middleware :refer :all]))

(defroutes app-routes
           (GET "/" [] "je$us loves amerika")
           (GET "/bootstrap" []
                (view/page {:title      "JE$US LOVES AMERIKA"
                            :header     "Home"
                            :navigation [{:text  "Home"
                                          :title "News and updates"
                                          :href  "/"}
                                         {:text  "Bio"
                                          :title "Coming soon..."
                                          :href  "#"}
                                         {:text  "Audio"
                                          :title "JLA on Bandcamp"
                                          :href  "http://jesuslovesamerika.bandcamp.com/"}
                                         {:text  "Tour"
                                          :title "Coming soon..."
                                          :href  "#"}
                                         {:text  "Gallery"
                                          :title "Coming soon..."
                                          :href  "#"}
                                         {:text  "Contact"
                                          :title "Email JLA"
                                          :href  "mailto:info&#64;jesuslovesamerika.co.uk"}
                                         {:text  "Links"
                                          :title "Coming soon..."
                                          :href  "#"}
                                         {:text  "Shop"
                                          :title "JLA on Bandcamp"
                                          :href  "http://jesuslovesamerika.bandcamp.com/"}]
                            :articles   [{:title "a" :content "aa<br />aaa"}
                                         {:title "b" :content "bbbbb"}
                                         {:title "c" :content "ccccc"}]}))
           (route/not-found "Not Found"))

(def app
  (-> app-routes
      (wrap-defaults site-defaults)                         ;; TODO: customise
      (wrap-logging)))
