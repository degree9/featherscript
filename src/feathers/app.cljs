(ns feathers.app
  (:refer-clojure :exclude [rest])
  (:require [goog.object :as obj]
            [feathers.authentication :as auth]
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
            [feathers.memory :as memory]
            [feathers.mailgun :as mailgun])
  (:require-macros feathers.app))

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

(def mailgun mailgun/using)

(defn authentication [app]
  (let [conf (.get app "auth")
        path (obj/get conf "path")
        app (auth/configure app conf)]
    (auth/service app path)))

(def authentication-management auth/configure-mgmt)

(defn static [feathers path]
  (fs/using feathers (fs/static path)))

(def listen fs/listen)

(def using fs/using)

(defn api [app path svc & [opts]]
  (let [app (fs/using app path svc)
        {:keys [before after error filter]} opts]
    (doto (fs/service app path)
      (.hooks (clj->js {:before before :after after :error error}))
      (.filter (clj->js filter)))
    app))
