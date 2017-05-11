import scala.scalajs.js

/**
 * Created by robby on 5/11/17.
 */
package object github {
  type RequestableCallback = js.Function3[js.Any, js.Dynamic, js.Dynamic, js.Any]
}
