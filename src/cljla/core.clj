(ns cljla.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [cljla.handler :as handler]
            [environ.core :refer [env]])
  (:gen-class))

(defn -main [& args]
  (prn "Starting application with args " args)
  (run-jetty handler/app {:port (Integer/parseInt (or (env :port)
                                                      "3000"))}))