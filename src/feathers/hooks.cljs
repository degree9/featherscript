(ns feathers.hooks
  (:refer-clojure :exclude [remove])
  (:require [cljs.nodejs :as node]
            [feathers.core :as fs]))

(def hooks (node/require "feathers-hooks"))

(defn configure [app]
  (fs/configure app (hooks)))

(defn remove [field]
  (.remove hooks field))
