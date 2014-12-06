(ns cljla.view
  (:require [net.cgrand.enlive-html :as html]))

(def bootstrap "public/templates/bootstrap.html")

(def articles-template "public/templates/partials/articles.html")

(html/defsnippet articles-snippet articles-template [:#articles] [articles]
                 ;[[:dl (html/but html/first-of-type)]] nil
                 {[:dt] [:dd]}
                 (html/clone-for [{:keys [content title]} articles]
                                 [:dt] (html/content title)
                                 [:dd] (html/content content)))

(html/deftemplate index-page bootstrap [{:keys [title header articles]}]
                  [:title] (html/content title)
                  [:h1] (html/content header)
                  [:#content] (html/content (articles-snippet articles)))

(defn page
  [content]
  (apply str (index-page content)))