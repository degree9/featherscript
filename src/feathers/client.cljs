(ns feathers.client
  (:require ["@feathersjs/client" :as feathers]))

(def client feathers)

(defn configure
  [app callback]
  (.configure app callback))

(defn jquery [app uri jquery]
  (configure app (.jquery (feathers/rest uri) jquery)))

(defn request [app uri request]
  (configure app (.request (feathers/rest uri) request)))

(defn socketio [app socket]
  (doto app
    (configure (feathers/socketio socket))))

(defn authentication [app conf]
  (doto app
    (configure (feathers/authentication conf))))

(defn service
  [app svc]
  (.service app svc))

(defn authenticate
  ([app] (.authenticate app))
  ([app conf] (.authenticate app conf)))

(defn reauthenticate [app]
  (.reAuthenticate app))

(defn logout
  [app]
  (.logout app))
