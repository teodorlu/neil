(ns babashka.neil.test-runner
  (:require [babashka.fs :as fs]
            [clojure.edn :as edn]
            [clojure.test :as t]))

(load-file (str (fs/parent *file*) "/../../../prelude"))
(load-file (str (fs/parent *file*) "/../../../tests.clj"))

(def test-namespaces
  '[tests
    babashka.neil.version-test])

(doseq [ns test-namespaces]
  (require ns))

(defn run-tests [& {:keys [nses]}]
  (let [selected-tests (if nses
                         (edn/read-string nses)
                         test-namespaces)
        test-results (apply t/run-tests selected-tests)
        {:keys [:fail :error]} test-results]
    (when (pos? (+ fail error))
      (throw (ex-info "Tests failed" {:babashka/exit 1})))))

(defn run-only
  {:org.babashka/cli {:coerce {:only [:symbol]}
                      :args->opts (repeat :only)}}
  [{:keys [only]}]
  (doseq [test-sym only]
    (let [t (requiring-resolve test-sym)]
      (assert t)
      (t))))
