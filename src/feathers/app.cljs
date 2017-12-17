(ns feathers.app
  (:refer-clojure :exclude [rest])
  (:require [goog.object :as obj]
            [feathers.authentication :as auth]
            [feathers.core :as fs]
            [feathers.configuration :as config]
            [feathers.rest :as rest]
            [feathers.socketio :as socketio]
            [feathers.express :as exp])
  (:require-macros feathers.app))

(defn feathers [] (fs/feathers))

(def express exp/expressify)

(def json exp/json)

(def urlencoded exp/urlencoded)

(def static exp/static)

(def configuration config/configure)

(def rest rest/configure)

(def socketio socketio/configure)

(defn authentication [app]
  (let [conf (.get app "auth")]
    (auth/configure app conf)))

(def listen fs/listen)

(def using fs/using)

(defn api [app path svc & [opts]]
  (let [app (fs/using app path svc)
        {:keys [before after error]} opts]
    (doto (fs/service app path)
      (.hooks (clj->js {:before before :after after :error error})))
    app))
