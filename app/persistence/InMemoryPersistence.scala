package persistence

import persistence.entities.Car

import scala.collection.mutable.ListBuffer
import scala.util.Random

object InMemoryPersistence extends Persistence[Car, Long, ListBuffer] {
  override val db: ListBuffer[Car] = ListBuffer.empty
  private val idGenerator = Random

  override def insert(car: Car): Car = {
    val idx = db.indexWhere(_.id == car.id)
    val newCar = car.copy(id=idGenerator.nextLong())
    if (idx > -1) {
      throw new RuntimeException(s"Duplicate element with id: ${car.id}")
    } else {
      db.addOne(newCar)
    }
    newCar
  }

  override def find(id: Long): Option[Car] = db.find(_.id == id)

  override def update(car: Car): Unit = {
    val idx = db.indexWhere(_.id == car.id)
    if (idx > -1) {
      db.update(idx, car)
    } else {
      throw new RuntimeException(s"No element to update with id: ${car.id}")
    }
  }

  override def delete(id: Long): Unit = {
    val idx = db.indexWhere(_.id == id)
    if (idx > -1) {
      db.remove(idx)
    } else {
      throw new RuntimeException(s"No element to delete with id: $id")
    }
  }

  override def findAll(): List[Car] = db.toList
}
