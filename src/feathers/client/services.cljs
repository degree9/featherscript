(ns feathers.client.services
  (:refer-clojure :exclude [find get update remove]))

(defn find [service & [params]]
   (.find service params))

(defn get [service id & [params]]
   (.get service id params))

(defn create [service data & [params]]
   (.create service data params))

(defn update [service id data & [params]]
  (.update service id data params))

(defn patch [service id data & [params]]
  (.patch service id data params))

(defn remove [service id & [params]]
  (.remove service id params))

(defn on [service event callback]
  (.on service event callback))

(defn created [service callback]
  (.on service "created" callback))

(defn updated [service callback]
  (.on service "updated" callback))

(defn patched [service callback]
  (.on service "patched" callback))

(defn removed [service callback]
  (.on service "removed" callback))
