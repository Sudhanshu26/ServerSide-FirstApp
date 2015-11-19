
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/sudhanshu/IdeaProjects/Sudhanshu/Sudhanshu_26/conf/routes
// @DATE:Wed Nov 04 18:36:36 IST 2015


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
