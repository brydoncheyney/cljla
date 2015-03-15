(ns cljla.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [cljla.view :as view]
            [cljla.middleware :refer :all]))

(defroutes app-routes
           (GET "/" [] "je$us loves amerika")
           (GET "/bootstrap" []
                (view/page {:title      "JE$US LOVES AMERIKA"
                            :header     "Home"
                            :navigation [{:text  "Home"
                                          :title "News and updates"
                                          :href  "/"}
                                         {:text  "Bio"
                                          :title "Coming soon..."
                                          :href  "#"}
                                         {:text  "Audio"
                                          :title "JLA on Bandcamp"
                                          :href  "http://jesuslovesamerika.bandcamp.com/"}
                                         {:text  "Tour"
                                          :title "Coming soon..."
                                          :href  "#"}
                                         {:text  "Gallery"
                                          :title "Coming soon..."
                                          :href  "#"}
                                         {:text  "Contact"
                                          :title "Email JLA"
                                          :href  "mailto:info&#64;jesuslovesamerika.co.uk"}
                                         {:text  "Links"
                                          :title "Coming soon..."
                                          :href  "#"}
                                         {:text  "Shop"
                                          :title "JLA on Bandcamp"
                                          :href  "http://jesuslovesamerika.bandcamp.com/"}]
                            :articles   [{:title   "Falling limited edition EP"
                                          :date    "2015-02-07"
                                          :content "<p>
	            Falling EP - available soon from <a href=\"http://www.armalyte.com/ARMCD023.htm\" title=\"Armalyte online store\">Armalyte Industries online store</a>. The SEVEN TRACK EP contains remixes from <a href=\"http://isolateband.com/\">Danny Carnage</a>, <a href=\"http://imusic.bandcamp.com/\">i!</a> and <a href=\"http://www.paresis.co.uk/\">Paresis</a>.
              </p>
              <p>
                    The Falling EP will be available at the <a href=\"http://www.brownpapertickets.com/event/1181770\">EP Launch Party</a> held at <a href=\"http://www.thepoetryclub.net/\">The Poetry Club</a> on 2015-02-07, with any remaining copies sold on online...
              </p>
              <p class=\"flyer\">
                <a href=\"http://www.armalyte.com/ARMCD023.htm\">
                <img src=\"/i/ARMCD023.jpg\" alt=\"Falling limited edition EP\" /></a>
              </p>"}
                                         {:title   "Falling EP Release Party"
                                          :date    "2015-02-07"
                                          :content "<p>
                Launch night for the new SEVEN TRACK EP - Falling - with live performances from je$us loves amerika and very special guests, <a href=\"https://www.facebook.com/metaltech\" title=\"\">METALTECH</a>.
              </p>
              <p>Saturday 7th February at <a href=\"http://www.thepoetryclub.net/\">The Poetry Club</a> - tickets &pound;5 / &pound;3 concession from  <a href=\"http://www.brownpapertickets.com/event/1181770\" title=\"Brown Paper Tickets\">Brown Paper Tickets</a></p>
              <p>The lead track, Falling, is once more produced by Phil Barry of <a href=\"http://bemyenemy.co.uk/\">Be My Enemy</a> fame and will be available in a very limited run of 100 hand numbered cd copies, on sale on the night.</p>
              <p>See the JLA <a href=\"http://www.facebook.com/jesuslovesamerika\" title=\"official facebook\">Facebook</a> page for more details...</p>
              <p class=\"flyer\">
                <a href=\"http://www.brownpapertickets.com/event/1181770\" title=\"Brown Paper Tickets\">
                   <img src=\"/i/20150207-flyer.jpg\" alt=\"Falling EP Release Party\" /></a>
              </p>"}
                                         {:title   "Psydoll/je&#36;us loves amerika - Ivory Blacks"
                                          :date    "2014-11-19"
                                          :content "<p>
                je&#36;us loves amerika are pleased to join japanese cyberpunks <a href=\"http://www.psydoll.com/\">Psydoll</a> on their Thunderbolt Tour at <a href=\"http://www.eventsforcharities.co.uk/\">Ivory Blacks</a> on Wednesday 19th November! more information and tickets available at <a href=\"http://www.tickets-scotland.com\" title=\"Tickets Scotland\">Tickets Scotland</a>
                and the
                <a href=\"http://www.eventsforcharities.co.uk/\">Events For Charities</a> box office.
              </p>
              <p>
                tickets are &pound;7, but we're offering discounted tickets at the following prices -
              </p>
              <ul>
                <li>standard: &pound;5</li>
                <li>student/unemployed: &pound;3</li>
              </ul>
              <p>see the JLA <a href=\"http://www.facebook.com/jesuslovesamerika\" title=\"official facebook\">Facebook</a> page for contact details!</p>
              <p class=\"flyer\">
                   <img src=\"/i/20141119-flyer.jpg\" alt=\"Ticketweb\" />
              </p>"}]}))
           (route/not-found "Not Found"))

(def app
  (-> app-routes
      (wrap-defaults site-defaults)                         ;; TODO: customise
      (wrap-logging)))
