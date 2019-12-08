(ns feathers.socketio
  (:require ["@feathersjs/socketio" :as sio]))

(defn socketio [app & [callback]]
  (.configure app (sio callback)))
