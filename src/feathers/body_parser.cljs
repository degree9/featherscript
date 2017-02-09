(ns feathers.body-parser
  (:require [cljs.nodejs :as node]
            [feathers.core :as fs]))

(def body-parser (node/require "body-parser"))

(defn json [app]
  (fs/using app (.json body-parser)))

(defn urlencoded [app conf]
  (fs/using app (.urlencoded body-parser conf)))
