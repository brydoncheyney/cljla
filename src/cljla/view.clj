(ns cljla.view
  (:require [net.cgrand.enlive-html :as html]))

(def bootstrap "public/templates/bootstrap.html")

(def articles-partial "public/templates/partials/articles.html")

(html/defsnippet articles articles-partial [:.article] [content])

(html/deftemplate index-page bootstrap [{:keys [title header]}]
                  [:title] (html/content title)
                  [:h1] (html/content header)
                  [:#content] (html/content (articles {})))

(defn page
  [content]
  (apply str (index-page content)))