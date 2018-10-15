(ns feathers.client
  (:refer-clojure :exclude [rest])
  (:require ["@feathersjs/client" :as feathers]))

(defn configure
  [app callback]
  (.configure app callback))

(defn jquery [app uri jquery]
  (configure app (.jquery (feathers/rest uri) jquery)))

(defn request [app uri request]
  (configure app (.request (feathers/rest uri) request)))

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
