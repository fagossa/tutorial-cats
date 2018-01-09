Tutorial cats
======

[![Build Status](https://travis-ci.org/fagossa/tutorial-cats.svg?branch=solution)](https://travis-ci.org/fagossa/tutorial-cats)


The exercises

## TODO `01` - `EqSpec`

Comparing with `Eq`, `===` and `=!=`


## TODO `02` - `PrintableSpec`

Implement the printable for `Gato` (spanish for `Cat`)

`cats` usually split `typeclasses` in the following way:
* A trait defining the general behavior
* A companion object that contains the type classes
* A syntax object containing `implicit class`es


## TODO `03` - `MonoidSpec`

Monoids can `combine` two elements of the same type (thanks to `semigroup`) and have an `empty` element


## TODO `04` - `FunctorSpec`

Playing with Functors in 

Functors can `map` over something


## TODO `05` - `WriteAndReadSpec`

Handling additional information to the main logic flow.

Note:
- This alias could be a good idea: `type Logged[A] = Writer[Vector[String], A]`
- Now, magic happens: `1.pure[Logged]`
- Anyways, this way also works: `1.writer(Vector.empty[String])`

> Write monad add additional information
> Read monad expects contextual information


## TODO `06` - `StateSpec`

Solving equations

> State Monad cumulates values


## TODO `07` - `ValidationSpec`

> Validation Monad and Either Monad handle errors


-----

## Problems?

If you are really, really, really having problems finding the right imports just include the following

```
import cats._
import cats.implicits._
```

however one of the goals of this exercise is to be able to __identify where the typeclass implementation is located__.

## Contribution policy ##

Contributions via GitHub pull requests are gladly accepted from their original author. Along with
any pull requests, please state that the contribution is your original work and that you license
the work to the project under the project's open source license. Whether or not you state this
explicitly, by submitting any copyrighted material via pull request, email, or other means you
agree to license the material under the project's open source license and warrant that you have the
legal authority to do so.