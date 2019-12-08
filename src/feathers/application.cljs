(ns feathers.application
  (:require [goog.object :as obj]
            ["@feathersjs/feathers" :as feathers])
  (:require-macros feathers.application))

(def app feathers)

(defn using [app path svc]
  (.use app path svc))

(defn service [app path]
  (.service app path))

(defn hooks [app hooks]
  (.hooks app hooks))

(defn publish
  ([app publisher] (.publish app publisher))
  ([app event publisher] (.publish app event publisher)))

(defn configure [app callback]
  (.configure app callback))

(defn listen [app & [port]]
  (.listen app port))

(defn setup [app server]
  (.setup app server))

(defn set [app name value]
  (.set app name value))

(defn get [app name]
  (.get app name))

(defn on [app event listener]
  (.on app event listener))

(defn emit [app event data]
  (.emit app event data))

(defn mixins [app]
  (.mixins app))

(defn services [app]
  (.services app))

(defn default-service [app svc]
  (obj/set app "defaultService" svc))

(defn api [app path svc & [hooks]]
  (-> app
    (.use path svc)
    (.service path)
    (.hooks (clj->js hooks)))
  app)
