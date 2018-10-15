(ns feathers.channels)

;; Feathers Connections ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn connection [^js app listener]
  (.on app "connection" listener))

(defn login [^js app listener]
  (.on app "login" listener))
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; Feathers Channels ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn channel [app channel]
  (.channel app channel))

(defn join [channel connection]
  (.join channel connection))

(defn leave [channel connection]
  (.leave channel connection))

(defn channels [app]
  (.channels app))

(defn connections [app]
  (.connections app))
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; Feathers Publishing ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn publish [appsvc fn]
  (.publish appsvc fn))
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
