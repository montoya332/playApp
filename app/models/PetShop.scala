package models

case class PetItem(id: Long, name: String, price: Double){
  println(s"My name is $name")
}

trait Franchise {
  def list(): Seq[PetItem]
  def details(id: Long): PetItem
}

object PetShop extends Franchise {
  val pet = PetItem(1,"kuma",30000)
  def list(): Seq[PetItem] = Seq(pet)
  def details(id: Long) = pet
}
