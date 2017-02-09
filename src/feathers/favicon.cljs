(ns feathers.favicon
  (:require [cljs.nodejs :as node]
            [feathers.core :as fs]))

(def favicon (node/require "serve-favicon"))

(defn using [app path]
  (fs/using app (favicon path)))
