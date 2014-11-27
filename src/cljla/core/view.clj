(ns cljla.core.view
  (:require [net.cgrand.enlive-html :as html]))

(def bootstrap "public/templates/bootstrap.html")

(html/deftemplate index-page bootstrap
                  [title]
                  [:title] (html/content title))

(defn page
  [title]
  (apply str (index-page title)))