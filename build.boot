(set-env!
  :resource-paths #{"src"}
  :dependencies   '[[org.clojure/clojure       "1.10.0"]
                    [org.clojure/clojurescript "1.10.520"]
                    [degree9/boot-semver       "1.8.0" :scope "test"]])

(require '[degree9.boot-semver :refer :all])

(task-options!
 pom    {:project 'degree9/featherscript
         :description "Feathersjs wrapper for ClojureScript."
         :url         "http://github.com/degree9/featherscript"
         :scm {:url "http://github.com/degree9/featherscript"}})

(deftask ci-deps
  "Force CI to fetch dependencies."
  []
  identity)

(deftask deploy
  "Build project for deployment to clojars."
  []
  (comp
    (version :minor 'inc :patch 'zero)
    (build-jar)
    (push-release)))

(deftask develop
  "Build project for local development."
  []
  (comp
    (version :develop true
             :minor 'inc
             :patch 'zero
             :pre-release 'snapshot)
    (watch)
    (build-jar)))
