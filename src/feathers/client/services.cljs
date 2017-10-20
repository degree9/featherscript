(ns feathers.client.services
  (:refer-clojure :exclude [find get update remove])
  (:require [feathers.client :as feathers]))

(def service feathers/service) ;; this seems to fix some load order issue

(defn on [app event callback]
  (let []
    (.on app event callback)))

(defn created [app callback]
  (.on app "created" callback))

(defn updated [app callback]
  (.on app "updated" callback))

(defn patched [app callback]
  (.on app "patched" callback))

(defn removed [app callback]
  (.on app "removed" callback))

(defn find [app & [params callback]]
  (.find app params callback))

(defn get
  ([app id]
    (.get app id))
  ([app id & [params callback]]
    (.get app id params callback)))

(defn create
  ([app data]
    (.create app (clj->js data)))
  ([app data params]
    (.create app (clj->js data) (clj->js data))))

(defn update [app id data & [params callback]]
  (.update app id data params callback))

(defn patch [app id data & [params callback]]
  (.patch app id data params callback))

(defn remove [app id & [params callback]]
  (.remove app id params callback))
