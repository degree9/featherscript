(ns feathers.authentication
  (:refer-clojure :exclude [rest])
  (:require [goog.object :as obj]
            [cljs.nodejs :as node]
            [feathers.core :as fs]
            ["@feathersjs/authentication" :as auth]
            ["@feathersjs/authentication-jwt" :as jwt]
            ["@feathersjs/authentication-local" :as local]
            ["@feathersjs/authentication-oauth2" :as oauth2]))

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
    (fs/configure (jwt))))

(defn configure-local [app]
  (fs/configure app (local)))

(defn configure-oauth2 [app conf]
  (fs/configure app (oauth2 conf)))

(defn configure-service [app conf]
  (let [svc   (fs/service app (obj/get conf "path"))
        hooks (clj->js {:before {:create [(authenticate (obj/get conf "strategies"))]}})]
    (prn (obj/get conf "strategies"))
    (.hooks svc hooks)
    app))
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
