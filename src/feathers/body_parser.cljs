(ns feathers.body-parser
  (:require [cljs.nodejs :as node]
            [feathers.core :as fs]))

(def body-parser (node/require "body-parser"))

(defn json [app]
  (fs/use app (.json body-parser)))

(defn urlencoded [app conf]
  (fs/use app (.urlencoded body-parser conf)))
