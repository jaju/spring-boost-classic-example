;; [[file:../../../../../../README.org::*The Clojure Code][The Clojure Code:1]]
(ns org.msync.spring-clj.core
  (:require [clojure.string]
            [compojure.core :refer :all]
            [compojure.route :refer [not-found]]
            [org.msync.spring-boost :as boost])
  (:import [java.util.logging Logger]
           [org.springframework.context ApplicationContext]))

(defonce logger (Logger/getLogger (str *ns*)))

(defroutes app
  "Root hello-world GET endpoint, and another echo end-point that handles both GET and POST.
  The :body entry in the request-map comes in either as a map for JSON requests, or as a String
  for other types."
  (GET "/" [:as {query-string :query-string}]
       (str "<h1>Hello World.</h1>"
            (if-not (clojure.string/blank? query-string) (str "We received a query-string " query-string))))
  (GET "/echo/:greeter" [greeter]
       {:status 200
        :headers {:content-type "application/json"}
        :body {:greeting (str "Hello, " greeter)}})
  (POST "/echo/:greeter" [greeter :as request]
        {:status 200
         :headers {:content-type "application/json"}
         :body {:greetings (str "Hello, " greeter)
                :echo (:body request)}})
  (not-found "<h1>Page not found</h1>"))

(defn main
  "Set this as your entry-point for the Clojure code in your spring-boot app.
  Gets the ApplicationContext object as an argument - which you are free to ignore or use."
  [^ApplicationContext application-context]
  (.info logger (str "[spring-clj] Initializing configured clojure web-app..."))
  (boost/set-handler! app))
;; The Clojure Code:1 ends here
