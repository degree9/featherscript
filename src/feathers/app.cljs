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

;(defn session [app]
;  (let [conf (.get app "auth")
;        secret (obj/get conf "secret")
;    (exp/session app #js{:secret secret}))

(def configuration config/configure)

(def rest rest/configure)

(def socketio socketio/configure)

(def authentication auth/configure)

(def listen feathers/listen)

(def using feathers/use)

(defn api [app path svc & [{:keys [before after error]}]]
  (let [app (.use app path svc)]
    (doto (.service app path)
      (.hooks (clj->js {:before before :after after :error error})))
    app))
