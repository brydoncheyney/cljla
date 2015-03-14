(ns cljla.middleware
  (:require [clojure.pprint :refer [pprint]]
            [clojure.tools.logging :as log]))

(defn wrap-logging
  [app]
  (fn [request]
    (log/info request)
    (app request)))