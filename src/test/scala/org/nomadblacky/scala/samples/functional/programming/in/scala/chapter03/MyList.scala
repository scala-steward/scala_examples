package org.nomadblacky.scala.samples.functional.programming.in.scala.chapter03

/**
  * Created by blacky on 17/02/16.
  */
sealed trait MyList[+A]
case object MyNil extends MyList[Nothing]
case class Cons[+A](head: A, tail: MyList[A]) extends MyList[A]

object MyList {

  def sum(ints: MyList[Int]): Int = ints match {
    case MyNil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: MyList[Double]): Double = ds match {
    case MyNil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }

  def apply[A](as: A*): MyList[A] =
    if (as.isEmpty) MyNil
    else Cons(as.head, apply(as.tail: _*))

  def tail[A](list: MyList[A]): MyList[A] = list match {
    case MyNil => MyNil
    case Cons(_, MyNil) => MyNil
    case Cons(_, Cons(x, y)) => Cons(x, y)
  }

  def setHead[A](list: MyList[A], a: A): MyList[A] = list match {
    case MyNil => MyNil
    case Cons(_, MyNil) => Cons(a, MyNil)
    case Cons(_, Cons(x, y)) => Cons(a, Cons(x, y))
  }

  def drop[A](list: MyList[A], i: Int) = {
    def next(list: MyList[A], i: Int): MyList[A] = {
      if (i <= 0) list
      else list match {
        case MyNil => MyNil
        case Cons(_, x) => next(x, i - 1)
      }
    }
    next(list, i)
  }
}
