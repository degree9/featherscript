(ns feathers.client
  (:refer-clojure :exclude [rest])
  (:require ["@feathersjs/client" :as feathers]
            ["jquery" :as jquery]))

(defn configure
  [app callback]
  (.configure app callback))

(defn rest [app]
  (configure app (jquery/jquery (feathers/rest))))

(defn socketio [app socket]
  (configure app (feathers/socketio socket)))

(defn authentication [app conf]
  (configure app (feathers/authentication conf)))

(defn service
  [app svc]
  (.service app svc))

(defn authenticate
  ([app] (.authenticate app))
  ([app conf] (.authenticate app (clj->js conf))))

(defn logout
  [app]
  (.logout app))
