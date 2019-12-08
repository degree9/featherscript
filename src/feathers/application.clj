(ns feathers.application)

(defmacro with-hook
  "Create a hook which must return a hook object or promise."
  [hook & body]
  `(fn [hook#]
    (let [~hook hook#
          result# (do ~@body)]
        result#)))

(defmacro with-promise
  "Create a promise which resolves body."
  [& body]
  `(js/Promise.
    (fn [resolve# _#]
      (let [result# (do ~@body)]
        (resolve# result#)))))

(defmacro mkhook
  "Create a hook which returns a promise."
  [hook & body]
  `(feathers.app/with-hook ~hook
    (feathers.app/with-promise ~@body)))

(defmacro defhook
  "Define an async hook which returns a hook object."
  [name hook & body]
  (let [hook (if (vector? hook) (first hook) hook)]
    `(def ~name (feathers.app/with-hook ~hook ~@body))))
