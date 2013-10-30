(defproject {{name}} "0.0.1-SNAPSHOT"
  :description "Leiningen template for ClojureScript lib"
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"
            :distribution :repo}
  ;; required by cljsbuild  plugin
  :min-lein-version "2.1.2"

  ;; we need to add src/cljs too, because cljsbuild does not add its
  ;; source-paths to the project source-paths
  :source-paths ["src/clj" "src/cljs"]

  ;; the libs which the project depends on
  ;; here we use the latest stable clj and cljs repleses
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-1978"]]

  ;; the plugins which the project depends on.  here we're using the
  ;; experimental 1.0.0-SNAPSHOT release. Change it to the the
  ;; official 1.0.0 as soon as it will be availabe
  :plugins [[lein-cljsbuild "1.0.0-SNAPSHOT"]]

  ;; hooks the cljsbuild subtack to the lein tasks:
  ;; * lein clean
  ;; * lein compile
  ;; * lein test
  ;; * lein jar
  :hooks [leiningen.cljsbuild]

  ;; lein-cljsbuild plugin configuration. Here we define one build
  ;; only: the one used for pagkaging any cljs sources in the jar
  ;; generated by lein jar command
  :cljsbuild
  {:builds {;; this build is only used for including any cljs source
            ;; in the packaged jar when you issue lein jar command and
            ;; any other command that depends on it
            :deploy
            {;; the dir pathnames where cljs sources live. Do not
             ;; include here any cljs source which is only used during
             ;; develpment or testing
             :source-paths ["src/cljs"]
             ;; needed to include the sources in the packaged jar
             :jar true
             ;; Google Closure Compilation Options
             :compiler
             {;; the file pathname emitted by the Google Closure
              :output-to "dev-resources/public/js/deploy.js"
              ;; Google Closure Optimization option
              :optimizations :whitespace
              ;; prettify the emitted js file
              :pretty-print true}}}})
