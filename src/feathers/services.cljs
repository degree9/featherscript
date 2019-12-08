(ns feathers.services
  (:refer-clojure :exclude [find get update remove filter]))

(defprotocol IFeathersService
  (find [this params])
  (get  [this id params])
  (create [this data params])
  (update [this id data params])
  (patch [this id data params])
  (remove [this id params])
  (setup [this app path])
  (hooks [this hooks])
  (publish [this publisher] [this event publisher])
  (mixin [this mixin])
  (on [this event listener])
  (emit [this event data])
  (removelistener [this event] [this event callback]))

(extend-type object
  IFeathersService
  (find [this params]
    (.find this params))
  (get [this id params]
    (.get this id params))
  (create [this data params]
    (.create this data params))
  (update [this id data params]
    (.update this id data params))
  (patch [this id data params]
    (.patch [this id data params]))
  (remove [this id params]
    (.remove this id params))
  (setup [this app path]
    (.setup this app path))
  (hooks [this hooks]
    (.hooks this hooks))
  (publish
    ([this publisher]
     (.publish this publisher))
    ([this event publisher]
     (.publish this event publisher)))
  (mixin [this mixin]
    (.mixin this mixin))
  (on [this event callback]
    (.on this event callback))
  (emit [this event data]
    (.emit this event data))
  (removelistener
    ([this event]
     (.removelistener this event))
    ([this event callback]
     (.removelistener this event callback))))
