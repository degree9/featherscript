(ns feathers.socketio
  (:require [cljs.nodejs :as node]
            [feathers.core :as fs]))

(def socketio (node/require "@feathersjs/socketio"))

(defn configure [app]
  (fs/configure app (socketio)))
