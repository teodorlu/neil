(ns babashka.neil.dep
  "Domain model for deps as treated by Neil.")

;; Examples of deps:

{:neil.dep/symbol 'org.babashka/http-client
 :mvn/version "0.1.4"}
{:neil.dep/symbol 'io.github.seancorfield/deps-new
 :git/url "https://github.com/seancorfield/deps-new"
 :git/tag "v0.5.0"
 :git/sha "48bf01e"}

(defn mvn-version [dep]
  (get dep :mvn/version))

(defn dep-symbol [dep]
  (get dep :neil.dep/symbol))

(defn dep [dep-symbol dep-map]
  (assoc dep-map :neil.dep/symbol dep-symbol))

(defn coerce-dep-symbol
  "Create a dep-symbol from a string or a symbol, fully qualify when needed.

  (coerce-dep-symbol \"hiccup\")
  ;; => hiccup/hiccup

  (coerce-dep-symbol 'hiccup)
  ;; => hiccup/hiccup

  (coerce-dep-symbol 'hiccup/hiccup)
  ;; => hiccup/hiccup"
  [dep-symbol-or-string]
  (let [dep-symbol (symbol dep-symbol-or-string)]
    (symbol (or (namespace dep-symbol) (name dep-symbol))
            (name dep-symbol))))
