(ns feathers.hooks
  (:refer-clojure :exclude [remove])
  (:require [cljs.nodejs :as node]
            [feathers.core :as fs]))

(def hooks (node/require "feathers-hooks"))

(def common (node/require "feathers-hooks-common"))

(defn configure [app]
  (fs/configure app (hooks)))

(defn iff [pred hook]
  (.iff common pred hook))

(defn isProvider [provider]
  (.isProvider common provider))

(defn preventChanges [field]
  (.preventChanges common field))

(defn remove [field]
  (.remove common field))

(defn disallow [provider]
  (.disallow common provider))
