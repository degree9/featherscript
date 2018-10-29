(ns feathers.app
  (:refer-clojure :exclude [rest])
  (:require [goog.object :as obj]
            [feathers.authentication :as auth]
            ["@feathersjs/feathers" :as feathers]
            [feathers.configuration :as config]
            [feathers.rest :as rest]
            [feathers.socketio :as socketio]
            [feathers.express :as exp])
  (:require-macros feathers.app))

(def app feathers)

(def express exp/expressify)

(def json exp/json)

(def urlencoded exp/urlencoded)

(def static exp/static)

(def configuration config/configure)

(def rest rest/configure)

(def socketio socketio/configure)

(defn authentication
  ([^js app] (authentication app "/authentication"))
  ([^js app path]
   (let [conf (.get app "auth")
         app  (auth/configure app conf)]
      (auth/service app path))))

(def listen feathers/listen)

(def using feathers/use)

(defn api [app path svc & [opts]]
  (let [app (.use app path svc)
        {:keys [before after error]} opts]
    (doto (.service app path)
      (.hooks (clj->js {:before before :after after :error error})))
    app))
