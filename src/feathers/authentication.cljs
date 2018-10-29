(ns feathers.authentication
  (:refer-clojure :exclude [rest])
  (:require [goog.object :as obj]
            [cljs.nodejs :as node]
            [feathers.core :as fs]
            ["@feathersjs/authentication" :as auth]
            ["@feathersjs/authentication-jwt" :as jwt]
            ["@feathersjs/authentication-local" :as local]))

;; Authentication Hooks ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(def hooks
  (merge
    (-> auth
      (obj/get "hooks")
      (js->clj :keywordize-keys true))
    (-> local
      (obj/get "hooks")
      (js->clj :keywordize-keys true))))

(defn authenticate [strategies]
  (let [auth  (:authenticate hooks)]
    (auth. strategies)))

(defn hash-password []
  (let [hash (:hashPassword hooks)]
    (hash.)))

(defn protect-password []
  (let [protect (:protect hooks)]
    (protect. "password")))
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; Authentication Services ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn configure [app conf]
  (-> app
    (fs/configure (auth conf))
    (fs/configure (jwt))
    (fs/configure (local))))

(defn service [app path]
  (let [svc   (fs/service app path)
        hooks (clj->js {:before {:create [(authenticate #js["jwt" "local"])]}})]
    (.hooks svc hooks)
    app))
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
