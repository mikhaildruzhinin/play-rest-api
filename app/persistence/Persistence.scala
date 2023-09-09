package persistence

trait Persistence[A, B, C[_]] {
  val db: C[_]
  def insert(entity: A): A
  def find(id: B): Option[A]
  def update(entity: A): Unit
  def delete(id: B): Unit
  def findAll(): List[A]
}
