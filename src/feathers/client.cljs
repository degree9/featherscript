(ns feathers.client
  (:refer-clojure :exclude [rest])
  (:require [cljsjs.feathers]
            [cljsjs.jquery]))

(def feathers js/feathers)

(defn configure
  [app callback]
  (.configure app callback))

(defn rest [app]
  (configure app (.jquery (.rest feathers) js/jquery)))

(defn socketio [app socket]
  (configure app (.socketio feathers socket)))

(defn hooks [app]
  (configure app (.hooks feathers)))

(defn authentication [app conf]
  (configure app (.authentication feathers conf)))

(defn service
  [app svc]
  (.service app svc))

(defn authenticate
  ([app] (.authenticate app))
  ([app conf] (.authenticate app (clj->js conf))))

(defn logout
  [app]
  (.logout app))
