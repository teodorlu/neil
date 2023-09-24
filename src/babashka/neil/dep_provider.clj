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

;; Q: What about our scripts? They still rely (a lot) on editing real files on
;; disk. Is that a good idea?
;;
;; I don't like having to touch files in unit tests. I'd prefer to work on an
;; abstraction that represents project files, including deps.edn. Then be able
;; to serialize those changes.

;; Q: Should this be done now?
;;
;; I'm having a hard time finding motivation to start work right now. Do we need
;; it? Will we get it merged?
;;
;; In general, I don't favor refactoring for refactoring's sake. Perhaps I
;; should try fix some real problems instead.
