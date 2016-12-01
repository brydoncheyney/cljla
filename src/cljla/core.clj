(ns cljla.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [com.stuartsierra.component :as component]
            [environ.core :refer [env]]
            [cljla.handler :as handler]
            [clojure.tools.logging :as log])
  (:gen-class))

(defrecord ApplicationComponent [port]
  component/Lifecycle

  (start [component]
    (log/info (format ";; starting ApplicationComponent on port %s" port))
    (let [application (run-jetty handler/app {:port port :join? false})]
      (assoc component :application application)))

  (stop [component]
    (log/info ";; stopping ApplicationComponent")
    (when-let [application (:application component)]
      (.stop application)
      (.join application))
    (dissoc component :application)))

(defn new-application
  [port]
  (map->ApplicationComponent {:port port}))

(defn system
  [port]
  (component/system-map
    :app (new-application port)))

(def port (Integer. (or (env :port) "3000")))

(defn shutdown-hook
  [f]
  (.addShutdownHook (Runtime/getRuntime) (Thread. f)))

(defn -main [& args]
  (log/info ";; starting application with args" args)
  (let [system (component/start-system (system port))]
    (log/info ";; started system")
    (shutdown-hook #(component/stop-system system))))