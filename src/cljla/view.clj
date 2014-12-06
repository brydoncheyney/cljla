(ns cljla.view
  (:require [net.cgrand.enlive-html :as html]))

(def bootstrap "public/templates/bootstrap.html")

(def articles-template "public/templates/partials/articles.html")

(html/defsnippet navigation-template bootstrap [:#navbar] [links]
                 [:ul [:li (html/but html/first-of-type)]] nil
                 [:ul [:li html/first-of-type]]
                 (html/clone-for [{:keys [text title href]} links]
                                 [:li] (if (not= href "/") (html/remove-class "active") identity)
                                 [:li :a] (html/set-attr :href href :title title)
                                 [:li :a] (html/content text)))

(html/defsnippet articles-snippet articles-template [:#articles] [articles]
                 {[:dt] [:dd]}
                 (html/clone-for [{:keys [content title]} articles]
                                 [:dt] (html/content title)
                                 [:dd] (html/content content)))

(html/deftemplate index-page bootstrap [{:keys [title header navigation articles]}]
                  [:title] (html/content (str title " | " header ))
                  [:h1] (html/content title)
                  [:#navbar] (html/content (navigation-template navigation))
                  [:#content] (html/content (articles-snippet articles)))

(defn page
  [content]
  (apply str (index-page content)))