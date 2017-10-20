(ns feathers.mailgun
  (:require [cljs.nodejs :as node]
            [feathers.core :as fs]))

(def mailgun (node/require "feathers-mailgun"))

(defn using
  ([app path] (fs/using app path (mailgun)))
  ([app path conf] (fs/using app path (mailgun conf))))
