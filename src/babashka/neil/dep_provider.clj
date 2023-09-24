(ns babashka.neil.dep-provider)

;; a dep provider provides dependencies.

;; Q: What dep providers do we have?
;;
;; - Maven
;; - Clojars
;; - Github (?)
;; - Git (?)

;; Q: What operations are supported on a dep provider?
;;
;; - Add a dep from an identification string
;; - Upgrade a dep

;; Why?
;;
;; Because we currently rely on HTTP interactions to run our tests. I believe
;; introducing an abstraction for dep providers will make our code more
;; testable, and easier to read.

;; (defprotocol DepProvider ,,,)
