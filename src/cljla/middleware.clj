(ns cljla.middleware)

(defn wrap-logging
  [app]
  (fn [request]
    (prn request)
    (app request)))