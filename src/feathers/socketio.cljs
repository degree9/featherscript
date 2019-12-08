(ns feathers.socketio
  (:require ["@feathersjs/socketio" :as socketio]))

(defn socketio [app & [callback]]
  (.configure app (socketio callback)))
