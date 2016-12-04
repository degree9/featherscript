(ns feathers.hooks
  (:require [cljs.nodejs :as node]
            [feathers.core :as fs]))

(def hooks (node/require "feathers-hooks"))

(defn configure [app]
  (fs/configure app (hooks)))
