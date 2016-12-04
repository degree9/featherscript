(ns feathers.app
  (:refer-clojure :exclude [rest])
  (:require [feathers.core :as fs]
            [feathers.cors :as cors]
            [feathers.configuration :as config]
            [feathers.compression :as compression]
            [feathers.favicon :as favicon]
            [feathers.body-parser :as body-parser]
            [feathers.hooks :as hooks]
            [feathers.rest :as rest]
            [feathers.socketio :as socketio]
            [feathers.express :as express]))

(defn feathers! [] (fs/feathers))

(def configuration config/configure)

(def compress compression/use)

(defn cors [app]
  (-> app
    (express/options "*" (cors/cors))
    (cors/use)))

(def favicon favicon/use)

(defn body-parser [app]
  (-> app
    body-parser/json
    (body-parser/urlencoded #js{:extended true})))

(def hooks hooks/configure)

(def rest rest/configure)

(def socketio socketio/configure)

(def api fs/use)

(defn static [feathers path]
  (fs/use feathers (fs/static path)))

(def listen fs/listen)
