(defproject cljla "0.1.0-SNAPSHOT"
            :description "Je$us Loves Amerika web application"
            :url "http://www.jesuslovesamerika.co.uk"
            :min-lein-version "2.0.0"
            :dependencies [[org.clojure/clojure "1.6.0"]
                           [compojure "1.3.1"]
                           [ring/ring-defaults "0.1.4"]
                           [ring/ring-jetty-adapter "1.3.2"]
                           [enlive "1.1.5"]]
            :plugins [[lein-ring "0.8.13"]]
            :ring {:handler cljla.handler/app}
            :profiles {:dev     {:plugins      [[lein-midje "3.1.3"]
                                                [lein-ancient "0.6.2"]
                                                [lein-kibit "0.0.8"]
                                                [jonase/eastwood "0.2.1"]]
                                 :dependencies [[javax.servlet/servlet-api "2.5"]
                                                [ring-mock "0.1.5"]
                                                [midje "1.6.3"]]}
                       :uberjar {:uberjar-name "cljla.jar"
                                 :main         cljla.core
                                 :aot          :all}})
