(ns feathers.app
  (:refer-clojure :exclude [rest])
  (:require [feathers.authentication :as auth]
            [feathers.core :as fs]
            [feathers.cors :as cors]
            [feathers.configuration :as config]
            [feathers.compression :as compression]
            [feathers.favicon :as favicon]
            [feathers.body-parser :as body-parser]
            [feathers.hooks :as hooks]
            [feathers.rest :as rest]
            [feathers.socketio :as socketio]
            [feathers.express :as express]
            [feathers.memory :as memory]))

(defn feathers [] (fs/feathers))

(def configuration config/configure)

(def compress compression/using)

(defn cors [app]
  (-> app
    (express/options "*" (cors/cors))
    (cors/using)))

(def favicon favicon/using)

(defn body-parser [app]
  (-> app
    body-parser/json
    (body-parser/urlencoded #js{:extended true})))

(def hooks hooks/configure)

(def rest rest/configure)

(def socketio socketio/configure)

(def memory memory/using)

(defn authentication [app]
  (let [conf (.get app "auth")
        app (auth/configure app conf)]
    (auth/service app)))

(defn static [feathers path]
  (fs/using feathers (fs/static path)))

(def listen fs/listen)

(defn api [app path svc & [hooks]]
  (let [app (fs/using app path svc)
        {:keys [before after]} hooks]
    (doto (fs/service app path)
      (.before (clj->js before))
      (.after (clj->js after)))
    app))
