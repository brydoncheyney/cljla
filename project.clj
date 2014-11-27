(defproject cljla "0.1.0-SNAPSHOT"
  :description "Je$us Loves Amerika web application"
  :url "http://www.jesuslovesamerika.co.uk"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.2.0"]
                 [ring/ring-defaults "0.1.2"]
                 [midje "1.6.3"]
                 [enlive "1.1.5"]]
  :plugins [[lein-ring "0.8.13"]
            [lein-midje "3.1.3"]]
  :ring {:handler cljla.handler/app}
  :user {:plugins [[lein-midje "3.1.3"]]}
  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]
                        [midje "1.6.3"]]}})
