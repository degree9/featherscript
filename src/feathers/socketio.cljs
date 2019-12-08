(ns feathers.socketio
  (:require ["@feathersjs/socketio" :as socketio]))

(defn configure [app & [callback]]
  (.configure app (socketio callback)))
