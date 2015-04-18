(ns cljla.test.view
  (:require [midje.sweet :refer [facts fact =>]]
            [cljla.test.html-inspectors :refer [select select-single has-content?]]
            [cljla.test.selectors :as selectors]
            [cljla.view :refer :all]))

(facts "index template function should render content"
       (let [content (page {:title    "foo"
                            :header   "bar"
                            :articles [{:title   "Article 1"
                                        :content "text here"
                                        :date    "2015-01-01"}
                                       {:title   "Article 2"
                                        :content "more text here"
                                        :date    "2015-01-01"}]})]
         (fact "page title"
               (-> content (select-single [:title])) => (has-content? "foo | bar"))
         (fact "h1"
               (-> content (select-single [:h1])) => (has-content? "foo"))
         (fact "articles"
               (-> content (select selectors/news->articles->titles) count) => 2)
         (fact "article title"
               (-> content (select selectors/news->articles->titles) first) => (has-content? "Article 1 - 2015-01-01"))))
