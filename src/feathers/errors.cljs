(ns feathers.errors
  (:require ["@feathersjs/errors" :as error]))

(defn feathers-error [msg name code class & [data]]
  (error/FeathersError. msg name code class data))

(defn bad-request [err & [data]]
  (error/BadRequest. err data))

(defn not-authenticated [err & [data]]
  (error/NotAuthenticated. err data))

(defn payment-error [err & [data]]
  (error/PaymentError. err data))

(defn forbidden [err & [data]]
  (error/Forbidden. err data))

(defn not-found [err & [data]]
  (error/NotFound. err data))

(defn method-not-allowed [err & [data]]
  (error/MethodNotAllowed. err data))

(defn not-acceptable [err & [data]]
  (error/NotAcceptable. err data))

(defn timeout [err & [data]]
  (error/Timeout. err data))

(defn conflict [err & [data]]
  (error/Conflict. err data))

(defn length-required [err & [data]]
  (error/LengthRequired. err data))

(defn Unprocessable [err & [data]]
  (error/Unprocessable. err data))

(defn too-many-requests [err & [data]]
  (error/TooManyRequests. err data))

(defn general-error [err & [data]]
  (error/GeneralError. err data))

(defn not-implemented [err & [data]]
  (error/NotImplemented. err data))

(defn bad-gateway [err & [data]]
  (error/BadGateway. err data))

(defn unavailable [err & [data]]
  (error/Unavailable. err data))
