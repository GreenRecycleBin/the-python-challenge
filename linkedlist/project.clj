(defproject linkedlist "1.0"
  :description "Solution to problem 4: linkedlist"
  :url "http://www.pythonchallenge.com/pc/def/linkedlist.php"
  :license {:name "GNU General Public License v3.0"
            :url "http://www.gnu.org/copyleft/gpl.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [clj-http "0.9.2"]]
  :main ^:skip-aot linkedlist.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
