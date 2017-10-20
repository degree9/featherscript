(ns feathers.services
  (:refer-clojure :exclude [find get update remove filter])
  (:require [cljs.nodejs :as node]
            [feathers.core :as fs]))

(def service fs/service)

(defprotocol IFeathersService
  (find [service params])
  (get  [service id params])
  (create [service data params])
  (update [service id data params])
  (patch [service id data params])
  (remove [service id params])
  (setup [service app path])
  (filter [service filters])
  (on [service event callback])
  (emit [service event data])
  (removelistener [service event] [service event callback]))

(extend-type object
  IFeathersService
  (find [service params]
    (.find service params))
  (get [service id params]
    (.get service id params))
  (create [service data params]
    (.create service (clj->js data) params))
  (update [service id data params]
    (.update service id (clj->js data) params))
  (patch [service id data params]
    (.patch [service id (clj->js data) params]))
  (remove [service id params]
    (.remove service id params))
  (setup [service app path]
    (.setup service app path))
  (filter [service filters]
    (.filter service filters))
  (on [service event callback]
    (.on service event callback))
  (emit [service event data]
    (.emit service event (clj->js data)))
  (removelistener
    ([service event]
      (.removelistener service event))
    ([service event callback]
      (.removelistener service event callback))))
