package errors

object Errors {
  case class RepositoryError(message: String) extends Exception

  case class ManagerError(message: String) extends Exception
}
