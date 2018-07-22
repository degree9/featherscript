(ns feathers.socketio
  (:require [cljs.nodejs :as node]
            [feathers.core :as fs]
            ["@feathersjs/socketio" :as socketio]))

(defn configure [app & [callback]]
  (fs/configure app (socketio callback)))
