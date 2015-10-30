(ns cljla.middleware
  (:require [clojure.tools.logging :as log]
            [ring.util.response :refer [header]]))

(defn wrap-request-logging
  [handler]
  (fn [request]
    (log/debug request)
    (handler request)))

(defn wrap-json-response-headers
  [handler]
  (fn [request]
    (let [response (handler request)]
      (if (coll? (:body response))
        (header response "Content-Type" "application/json")
        response))))
