(defn read-file   [file] (read-string (slurp file)))
(defn get-deps    []     (read-file "./dependencies.edn"))
;(defn get-devdeps []     (read-file "./dev_dependencies.edn"))

(set-env!
 :dependencies   (get-deps)
 :resource-paths #{"src"})

(require
 '[hoplon.boot-hoplon :refer :all]
 '[degree9.boot-semver :refer :all]
 '[degree9.boot-semgit :refer :all]
 '[degree9.boot-semgit.workflow :refer :all]
 '[tolitius.boot-check :as check])

(task-options!
 pom    {:project 'hoplon/brew
         :version (get-version)
         :description "Experimental Hoplon Components."
         :url         "http://github.com/hoplon/brew"
         :scm {:url "http://github.com/hoplon/brew"}})

(deftask ci-deps
  "Force CI to fetch dependencies."
  []
  identity)

(deftask tests
  "Run code tests."
  []
  (comp
    (check/with-kibit)
    ;(check/with-yagni)
    (check/with-eastwood)
    (check/with-bikeshed)
    ))

(deftask deploy
  "Build project for deployment to clojars."
  []
  (comp
    (version :minor 'inc :patch 'zero)
    (hoplon  :manifest true)
    (build-jar)
    (push-release)))

(deftask develop
  "Build project for local development."
  []
  (comp
    (watch)
    (version :no-update true
             :minor 'inc
             :patch 'zero
             :pre-release 'snapshot)
    (hoplon :manifest true)
    (build-jar)))
